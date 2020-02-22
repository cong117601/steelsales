package com.ycxy.steelsales.service;

import com.ycxy.steelsales.pojo.function.SysFunction;

import java.util.List;

public interface UserFunction {
    //根据用户名查找该用户所具有的权限
    List<SysFunction> seleteUserFunctionByUsername(String loginName);
}
