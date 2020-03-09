package com.ycxy.steelsales.service.function.impl;

import com.ycxy.steelsales.mapper.function.SteelsaleFunctionMapper;
import com.ycxy.steelsales.pojo.function.SteelsaleFunction;
import com.ycxy.steelsales.service.function.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限实现类
 */
@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private SteelsaleFunctionMapper functionMapper;

    @Override
    public List<SteelsaleFunction> findAllFunction() {
        return functionMapper.selectAll();
    }

    @Override
    public void addFunction(SteelsaleFunction function) {
        functionMapper.insert(function);
    }

    @Override
    public void updateFunction(SteelsaleFunction function) {
        functionMapper.updateByPrimaryKeySelective(function);
    }

    @Override
    public void removeFunctionByFunctionId(Integer functionId) {
        functionMapper.deleteByPrimaryKey(functionId);
    }
}
