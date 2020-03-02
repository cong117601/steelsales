package com.ycxy.steelsales.mapper.employeepicture;

import com.ycxy.steelsales.pojo.employeepicture.SteelsaleEmployeePicture;
import com.ycxy.steelsales.pojo.employeepicture.SteelsaleEmployeePictureExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SteelsaleEmployeePictureMapper {
    int countByExample(SteelsaleEmployeePictureExample example);

    int deleteByExample(SteelsaleEmployeePictureExample example);

    int deleteByPrimaryKey(Integer pictureId);

    int insert(SteelsaleEmployeePicture record);

    int insertSelective(SteelsaleEmployeePicture record);

    List<SteelsaleEmployeePicture> selectByExample(SteelsaleEmployeePictureExample example);

    SteelsaleEmployeePicture selectByPrimaryKey(Integer pictureId);

    int updateByExampleSelective(@Param("record") SteelsaleEmployeePicture record, @Param("example") SteelsaleEmployeePictureExample example);

    int updateByExample(@Param("record") SteelsaleEmployeePicture record, @Param("example") SteelsaleEmployeePictureExample example);

    int updateByPrimaryKeySelective(SteelsaleEmployeePicture record);

    int updateByPrimaryKey(SteelsaleEmployeePicture record);

    /**
     * 修改图片根据员工id
     * @param employeeId
     * @param employeeImage
     */
    void updateScrByEid(@Param("employeeId") Integer employeeId, @Param("employeeImage") String employeeImage);
}