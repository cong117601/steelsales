package com.ycxy.steelsales.controller.employee;

import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.service.login.LoginService;
import com.ycxy.steelsales.service.role.RoleService;
import com.ycxy.steelsales.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 员工controller
 */
@Controller
public class EmployeeController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 跳转登陆页面
     */
    @RequestMapping("/")
    public String toLoginPage() {
        return "login";
    }

    /**
     * 员工登陆
     */
    @RequestMapping("/login1")
    public ModelAndView employeeLogin(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        SteelsaleEmployee employee = loginService.findEmployeeByUserName(name);
        //获取验证码
        String code = (String)redisUtil.get("code");
        System.out.println(code);
        //获取请求参数 验证码
        String captcha = request.getParameter("captcha");
        if(code==null||!code.equals(captcha)){
            modelAndView.setViewName("error");
            return modelAndView;

        }
        modelAndView.setViewName("index");
        modelAndView.addObject("role",name);
        redisUtil.set("employeeId",employee.getEmployeeId());
        System.out.println("hello");
        return modelAndView;
    }


}
