package com.ycxy.steelsales.pojo.employeeAndrole;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class SteelsaleEmployeeRole implements Serializable {
    private Integer erId;

    private Integer employeeId;

    private Integer roleId;

    public Integer getErId() {
        return erId;
    }

    public void setErId(Integer erId) {
        this.erId = erId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}