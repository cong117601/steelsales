package com.ycxy.steelsales.controller.main;

import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.service.employee.EmployeeService;
import com.ycxy.steelsales.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 找到密码
 * 发送邮箱
 * 发送短信
 */
@Controller
public class PassWordController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SendSms sendSms;

    /**
     * 找回密码
     */
    @RequestMapping("/employee/sendEmail")
    @ResponseBody
    public SteelSaleResult findPassWord(HttpServletRequest request) throws MessagingException, IOException {
        SteelSaleResult result = new SteelSaleResult();
        String email = request.getParameter("emailOrPhone");
        String captcha = request.getParameter("captcha");
        String code = (String) redisUtil.get("code");//redis中取得的验证码
        if (code == null || !captcha.equals(code)) {
            result.setMsg("请出入正确的验证码");
            return result;
        }
        //发送邮箱 内容为随机生成的密码，用于登陆，成功后即可 修改密码
        SendMail mail = new SendMail();
        /*
         * 单人发送
         * 调用setRecipient(String recipient);
         */
        mail.setRecipient(email); // 发送的位置

        // 邮件主题
        mail.setSubject("因酷教育找回密码");

        // 发送时间 Date类型(默认即时发送)
        mail.setDate(new Date());
        // 发送者昵称
        mail.setFrom("从哥钢材");
        // 邮件内容
        String randCode = getRandCode(6);//新密码
        mail.setContent("现在你的新密码为:" + getRandCode(6) + ",请勿泄露他人，请你及时登陆修改密码", "text/html; charset=UTF-8");

        //修改员工密码
        List<SteelsaleEmployee> employees = employeeService.selectEmployeeByEmail(email); //我确定它就一个
        SteelsaleEmployee employee = employees.get(0);
        employee.setLoginPwd(Md5Utils.stringToMD5(randCode));//1315899f54f73d8c34fd38c8678f5207
        employeeService.updateEmployee(employee);
        // 附件集合
        List<String> fileList = new ArrayList<String>();
//         添加附件
        fileList.add("");
        mail.setMultiparts(fileList);
        if (mail.sendMessage()) { // 是否发送成功
            result.setCode(0);
            return result;
        }
        return result;
    }

    /**
     * 发送电话找回密码
     */
    @RequestMapping("/employee/sendPhone")
    @ResponseBody
    public SteelSaleResult findPassWordByPhone(HttpServletRequest request) {
        SteelSaleResult result = new SteelSaleResult();
        //获取请求参数
        String captcha = request.getParameter("captcha");
        String employeeTel = request.getParameter("emailOrPhone");
        //获取缓存中的验证码
        String code = (String) redisUtil.get("code");
        //随机生成的新密码
        String randCode = getRandCode(6);
        if (captcha.equals(code)) {
                //根据该员工电话是否存在
                List<SteelsaleEmployee> steelsaleEmployees = employeeService.selectEmployeeByTel(employeeTel);
                SteelsaleEmployee employee = steelsaleEmployees.get(0);
                if (employee!=null){
                    //若存在发送短信验证码
                    SmsResult smsResult = sendSms.SendCode(employeeTel,randCode);
                    // 发送成功之后修改该员工的密码
                    if (!smsResult.getMessage().equals("OK")){
                        result.setMsg("发送异常");
                        return result;
                    }
                    employee.setLoginPwd(Md5Utils.stringToMD5(randCode));
                    employeeService.updateEmployee(employee);
                    result.setCode(0);
                    return result;
                }
        }
        result.setMsg("输入异常");
        return result;
    }

    /**
     * 生成随机验证码
     * 使用时间的
     *
     * @param digits
     * @return
     */
    private static String getRandCode(int digits) {
        StringBuilder sBuilder = new StringBuilder();
        Random rd = new Random((new Date()).getTime());

        for (int i = 0; i < digits; ++i) {
            sBuilder.append(String.valueOf(rd.nextInt(9)));
        }

        return sBuilder.toString();
    }
}
