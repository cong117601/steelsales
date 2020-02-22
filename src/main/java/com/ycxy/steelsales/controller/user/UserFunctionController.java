package com.ycxy.steelsales.controller.user;

import com.ycxy.steelsales.pojo.function.SysFunction;
import com.ycxy.steelsales.service.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserFunctionController {
    @Autowired
    private UserFunction userFunctionImpl;

    //查找用户权限功能
    @RequestMapping("/aa/login")
    public String findUserFunction(Model model) {
        String username = "admin";
        List<SysFunction> sysFunctions = userFunctionImpl.seleteUserFunctionByUsername(username);
        model.addAttribute("sysFunctions",sysFunctions);
        return "index";
    }
}
