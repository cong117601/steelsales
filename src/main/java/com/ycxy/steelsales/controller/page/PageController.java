package com.ycxy.steelsales.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 */
@Controller
public class PageController {
    //可以这样设计 但是我想多写点 你能咋滴
    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page") String page){
     return page;

}
    @RequestMapping("/toError")
    public String toErrorPage() {
        return "error";
    }

    @RequestMapping("/logout")
    public String toLogout() {

        return "login";
    }
    @RequestMapping("/password")
    public String toPsdPage() {
        return "password";
    }
    @RequestMapping("/register")
    public String toRegisterPage() {
        return "register";
    }

}
