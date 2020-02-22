package com.ycxy.steelsales.pojo.role;

import java.util.Date;

public class SteelsaleRole {
    private Integer roleId;//角色id

    private String roleName;//角色名字

    private Date createTime;//创建时间

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
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}