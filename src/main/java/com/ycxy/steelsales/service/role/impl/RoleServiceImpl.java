package com.ycxy.steelsales.service.role.impl;

import com.ycxy.steelsales.mapper.role.CustomRoleMapper;
import com.ycxy.steelsales.pojo.role.SteelsaleRole;
import com.ycxy.steelsales.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private CustomRoleMapper customRoleMapper;
    @Override
    public List<String> selectRole() {
        List<String> steelsaleRoles = customRoleMapper.selectAllRoleName();
        return steelsaleRoles;
    }

    @Override
    public List<String> selectRoleByLoginName(String loginName) {
        return customRoleMapper.selectRoleNameByLoginName(loginName);
    }
}
