package com.ycxy.steelsales.service.employeeAndrole;

import com.ycxy.steelsales.pojo.employeeAndrole.SteelsaleEmployeeRole;

/**
 * 员工与角色
 */
public interface EAndRoleService {
    /**
     * 添加关系
     */
    void addEmployeeAndRole(SteelsaleEmployeeRole employeeRoleG);

    /**
     * 通过员工id 修改角色
     * @param employeeId
     * @param eid
     */
    void editRolesByEmployeeId(Integer employeeId, Integer eid);

    /**
     * 删除员工角色
     * @param employeeId
     */
    void removeRoles(Integer employeeId);

//    /**
//     * 添加该员工的角色
//     * @param employeeId
//     * @param roleId
//     */
//    void addRolesByEmployeeId(Integer employeeId, Integer roleId);
}
