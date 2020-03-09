package com.ycxy.steelsales.service.role.impl;

import com.ycxy.steelsales.mapper.role.CustomRoleMapper;
import com.ycxy.steelsales.mapper.role.SteelsaleRoleMapper;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployeeExample;
import com.ycxy.steelsales.pojo.role.SteelsaleRole;
import com.ycxy.steelsales.pojo.role.SteelsaleRoleExample;
import com.ycxy.steelsales.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private CustomRoleMapper customRoleMapper;
    @Autowired
    private SteelsaleRoleMapper roleMapper;

    @Override
    public List<String> selectRole() {
        List<String> steelsaleRoles = customRoleMapper.selectAllRoleName();
        return steelsaleRoles;
    }

    @Override
    public List<String> selectRoleByLoginName(String loginName) {
        return customRoleMapper.selectRoleNameByLoginName(loginName);
    }

    @Override
    public List<SteelsaleRole> findRoles() {
        return customRoleMapper.selectAll();
    }

    @Override
    public List<Integer> findRolesByEmployeeId(Integer id) {

        return customRoleMapper.selectRoleIdByEid(id);
    }

    @Override
    public List<SteelsaleRole> findRoles(String roleName, Integer page, Integer limit) {
        Map map = new HashMap();
        map.put("roleName", roleName);
        List<SteelsaleRole> steelsaleRoles = customRoleMapper.selectAlls(map);
        return steelsaleRoles;
    }

    @Override
    public void addRole(SteelsaleRole steelsaleRole) {
        roleMapper.insert(steelsaleRole);
    }

    @Override
    public void removeRole(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SteelsaleRole findRoleById(Integer id) {
        SteelsaleRole role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public void editRole(SteelsaleRole role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public SteelsaleRole findRoleByRoleName(String roleName) {
        SteelsaleRoleExample steelsaleRoleExample = new SteelsaleRoleExample();
        SteelsaleRoleExample.Criteria criteria = steelsaleRoleExample.createCriteria();
        criteria.andRoleNameEqualTo(roleName);
        List<SteelsaleRole> steelsaleRoles = roleMapper.selectByExample(steelsaleRoleExample);
        return steelsaleRoles.get(0);
    }

}
