package com.ycxy.steelsales.pojo.employeepicture;

public class SteelsaleEmployeePicture {
    private Integer pictureId;

    private Integer employeeId;

    private String pictureSrc;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getPictureSrc() {
        return pictureSrc;
    }

    public void setPictureSrc(String pictureSrc) {
        this.pictureSrc = pictureSrc == null ? null : pictureSrc.trim();
    }
}