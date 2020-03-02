package com.ycxy.steelsales.service.employeeAndrole.impl;

import com.ycxy.steelsales.mapper.employeeAndrole.SteelsaleEmployeeRoleMapper;
import com.ycxy.steelsales.pojo.employeeAndrole.SteelsaleEmployeeRole;

import com.ycxy.steelsales.pojo.employeeAndrole.SteelsaleEmployeeRoleExample;
import com.ycxy.steelsales.service.employeeAndrole.EAndRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工与角色
 */
@Service
public class EAndRoleImpl implements EAndRoleService {
    @Autowired
    private SteelsaleEmployeeRoleMapper eAndRoleMapper;

    @Override
    public void addEmployeeAndRole(SteelsaleEmployeeRole employeeRoleG) {
        eAndRoleMapper.insert(employeeRoleG);
    }

    @Override
    public void editRolesByEmployeeId(Integer employeeId, Integer eid) {
        eAndRoleMapper.updateRoleByEid(employeeId,eid);
    }

    @Override
    public void removeRoles(Integer employeeId) {
        SteelsaleEmployeeRoleExample employeeRoleExample =new SteelsaleEmployeeRoleExample();
        SteelsaleEmployeeRoleExample.Criteria criteria = employeeRoleExample.createCriteria();
        criteria.andEmployeeIdEqualTo(employeeId);
        eAndRoleMapper.deleteByExample(employeeRoleExample);
    }

//    @Override
//    public void addRolesByEmployeeId(Integer employeeId, Integer roleId) {
//        eAndRoleMapper.insertByEmployeeId(employeeId,roleId);
//    }
}
