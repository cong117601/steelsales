package com.ycxy.steelsales.service.employeepicture.impl;

import com.ycxy.steelsales.mapper.employeepicture.SteelsaleEmployeePictureMapper;
import com.ycxy.steelsales.pojo.employeepicture.SteelsaleEmployeePicture;
import com.ycxy.steelsales.pojo.employeepicture.SteelsaleEmployeePictureExample;
import com.ycxy.steelsales.service.employeepicture.EPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class EPictureServiceImpl implements EPictureService {

    @Autowired
    private SteelsaleEmployeePictureMapper employeePictureMapper;

    @Override
    public void insertEpicture(SteelsaleEmployeePicture employeePicture) {
        employeePictureMapper.insert(employeePicture);
    }

    @Override
    public void editEpictureByEmId(Integer employeeId, String employeeImage) {

        employeePictureMapper.updateScrByEid(employeeId,employeeImage);
    }
}
