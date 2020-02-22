package com.ycxy.steelsales.service.role;

import com.ycxy.steelsales.pojo.role.SteelsaleRole;

import java.util.List;

/**
 * 角色服务
 */
public interface RoleService {
    //查询所有角色
    List<String> selectRole();
    //查询用户所属角色
    List<String> selectRoleByLoginName(String loginName);
}
