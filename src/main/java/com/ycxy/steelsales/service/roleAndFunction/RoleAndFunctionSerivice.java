package com.ycxy.steelsales.service.roleAndFunction;

import com.ycxy.steelsales.pojo.roleAndFunction.SteelsaleRoleFunction;

import java.util.List;

/**
 * 角色和权限关联
 */
public interface RoleAndFunctionSerivice {
    /**
     * 保存新增用户权限
     * @param roleFunction
     */
    void insertRoleOfFunction(SteelsaleRoleFunction roleFunction);

    /**
     * 根据角色id查找功能权限
     * @param id
     * @return
     */
    List<SteelsaleRoleFunction> findFunctionByRoleId(Integer id);

    /**
     * 删除该角色对应的权限
     * @param roleId
     */
    void removeFunctionByRoleId(Integer roleId);

    /**
     * 修改角色权限
     * @param roleId
     * @param
     */
    void updateFunctionByRoleId(Integer roleId, List<Integer> integers);

    /**
     * 删除权限根据权限id
     * @param functionId
     */
    void removeFunctionByFunctionId(Integer functionId);
}
