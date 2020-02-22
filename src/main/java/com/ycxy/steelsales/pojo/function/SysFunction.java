package com.ycxy.steelsales.pojo.function;

import java.io.Serializable;
import java.util.Date;

public class SysFunction implements Serializable {
    private Integer functionId;//权限id
    private Integer parentId;//权限父id
    private String functionName;//权限名
    private String functionUrl;//权限url
    private Integer functionType;//权限类型
    private Date createTime;//创建时间
    private Integer sort;//排序

    public SysFunction() {
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    public Integer getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Integer functionType) {
        this.functionType = functionType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SysFunction{" +
                "functionId=" + functionId +
                ", parentId=" + parentId +
                ", functionName='" + functionName + '\'' +
                ", functionUrl='" + functionUrl + '\'' +
                ", functionType=" + functionType +
                ", createTime=" + createTime +
                ", sort=" + sort +
                '}';
    }
}
