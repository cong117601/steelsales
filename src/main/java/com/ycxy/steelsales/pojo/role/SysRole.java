package com.ycxy.steelsales.pojo.role;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    private Integer roleId;//角色id
    private String roleName;//角色名
    private Date createTime;//创建时间

    public SysRole() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
