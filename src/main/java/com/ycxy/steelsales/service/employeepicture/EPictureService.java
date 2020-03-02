package com.ycxy.steelsales.service.employeepicture;

import com.ycxy.steelsales.pojo.employeepicture.SteelsaleEmployeePicture;

/**
 * 员工图片
 */
public interface EPictureService {
    /**
     * 插入员工图片
     * @param employeePicture
     */
    void insertEpicture(SteelsaleEmployeePicture employeePicture);

    /**
     * 根据员工id 修改图片
     * @param employeeId
     * @param employeeImage
     */
    void editEpictureByEmId(Integer employeeId, String employeeImage);
}
