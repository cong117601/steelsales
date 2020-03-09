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

    /**
     * 模糊查询
     * @param roleName
     * @param page
     * @param limit
     * @return
     */
    List<SteelsaleRole> findRoles(String roleName,Integer page,Integer limit);

    /**
     * 添加角色
     * @param steelsaleRole
     */
    void addRole(SteelsaleRole steelsaleRole);

    /**
     * 删除角色
     * @param id
     */
    void removeRole(Integer id);

    /**
     *
     * 通过id查找角色
     * @param id
     * @return
     */
    SteelsaleRole findRoleById(Integer id);

    /**
     * 修改角色
     * @param role
     */
    void editRole(SteelsaleRole role);

    /**
     * 根据角色名查找
     * @param roleName
     * @return
     */
    SteelsaleRole findRoleByRoleName(String roleName);
}
