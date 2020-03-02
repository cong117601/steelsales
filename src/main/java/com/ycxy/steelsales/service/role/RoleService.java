package com.ycxy.steelsales.service.role;

import com.ycxy.steelsales.pojo.role.SteelsaleRole;

import java.util.List;

/**
 * 角色服务
 */
public interface RoleService {
    /**
     * 查询所有角色
     * @return
     */
    List<String> selectRole();

    /**
     * 查询用户所属角色
     * @param loginName
     * @return
     */
    List<String> selectRoleByLoginName(String loginName);

    /**
     * 查找所有角色
     * @return
     */

    List<SteelsaleRole> findRoles();

    /**
     * 根据用户id 查找所属角色
     * @param id
     * @return
     */
    List<Integer> findRolesByEmployeeId(Integer id);
}
