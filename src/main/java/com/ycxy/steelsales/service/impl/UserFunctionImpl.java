package com.ycxy.steelsales.service.impl;

import com.ycxy.steelsales.mapper.function.SysFunctionMapper;
import com.ycxy.steelsales.pojo.function.SysFunction;
import com.ycxy.steelsales.service.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFunctionImpl implements UserFunction {

    @Autowired
    private SysFunctionMapper functionMapper;

    @Override
    public List<SysFunction> seleteUserFunctionByUsername(String loginName) {
        return functionMapper.seleteUserFunctionByUsername(loginName);
    }
}
