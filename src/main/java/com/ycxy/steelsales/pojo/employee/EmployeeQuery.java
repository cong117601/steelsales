package com.ycxy.steelsales.pojo.employee;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 自定义模糊查询条件
 */
public class EmployeeQuery implements Serializable {
    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 员工性别
     */
    private Byte employeeSex;

    /**
     * 员工状态 0：在职 1.离职'
     */
    private Byte status;
    /**
     * 员工邮箱
     */
    private String employeeEmail;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public EmployeeQuery() {
    }

    public EmployeeQuery(String employeeName, Byte employeeSex, Byte status, String employeeEmail, Date createTime, Date updateTime) {
        this.employeeName = employeeName;
        this.employeeSex = employeeSex;
        this.status = status;
        this.employeeEmail = employeeEmail;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Byte getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(Byte employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
