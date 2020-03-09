package com.ycxy.steelsales.service.roleAndFunction.impl;

import com.ycxy.steelsales.mapper.roleAndFunction.SteelsaleRoleFunctionMapper;
import com.ycxy.steelsales.pojo.roleAndFunction.SteelsaleRoleFunction;
import com.ycxy.steelsales.pojo.roleAndFunction.SteelsaleRoleFunctionExample;
import com.ycxy.steelsales.service.roleAndFunction.RoleAndFunctionSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工与角色实现类
 */
@Service
public class RoleAndFunctionSeriviceImpl implements RoleAndFunctionSerivice {

    @Autowired
    private SteelsaleRoleFunctionMapper rfMapper;

    @Override
    public void insertRoleOfFunction(SteelsaleRoleFunction roleFunction) {
        rfMapper.insert(roleFunction);
    }

    @Override
    public List<SteelsaleRoleFunction> findFunctionByRoleId(Integer id) {
        SteelsaleRoleFunctionExample roleFunctionExample = new SteelsaleRoleFunctionExample();
        SteelsaleRoleFunctionExample.Criteria criteria = roleFunctionExample.createCriteria();
        criteria.andRoleIdEqualTo(id);
        List<SteelsaleRoleFunction> steelsaleRoleFunctions = rfMapper.selectByExample(roleFunctionExample);
        return steelsaleRoleFunctions;
    }

    @Override
    public void removeFunctionByRoleId(Integer roleId) {
        SteelsaleRoleFunctionExample roleFunctionExample = new SteelsaleRoleFunctionExample();
        SteelsaleRoleFunctionExample.Criteria criteria = roleFunctionExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        rfMapper.deleteByExample(roleFunctionExample);
    }

    @Override
    public void updateFunctionByRoleId(Integer roleId, List<Integer> integers) {

        rfMapper.insertFunction(roleId,integers);
    }

    @Override
    public void removeFunctionByFunctionId(Integer functionId) {
        SteelsaleRoleFunctionExample roleFunctionExample = new SteelsaleRoleFunctionExample();
        SteelsaleRoleFunctionExample.Criteria criteria = roleFunctionExample.createCriteria();
        criteria.andFunctionIdEqualTo(functionId);
        rfMapper.deleteByExample(roleFunctionExample);
    }
}
