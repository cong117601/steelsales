package com.ycxy.steelsales.pojo.roleFunction;

import java.io.Serializable;

public class SysRoleFunction implements Serializable {
    private Integer roleId;//角色id
    private Integer functionId;//权限id

    public SysRoleFunction() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }
}
