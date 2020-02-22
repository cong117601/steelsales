package com.ycxy.steelsales.controller.main;

import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.service.employee.EmployeeService;
import com.ycxy.steelsales.util.RedisUtil;
import com.ycxy.steelsales.util.SteelSaleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册
 * 注册时添加到员工表 没有设计 在注册时就选择好角色
 * 需要注册成功之后在去修改
 */
@Controller
public class RegisterController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/employee/register")
    @ResponseBody
    public SteelSaleResult employeeRegister(SteelsaleEmployee employee, HttpServletRequest request) {
        SteelSaleResult result = new SteelSaleResult();
        String captcha = request.getParameter("captcha");
        String code = (String)redisUtil.get("code");
        if (code.equals(captcha)){
            //System.out.println(employee.getLoginName()+captcha);
            employeeService.addEmployee(employee);
            result.setCode(0);
            return result;
        }
        result.setMsg("注册失败");
        return result;
    }
}
