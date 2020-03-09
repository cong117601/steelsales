package com.ycxy.steelsales.mapper.employee;

import com.ycxy.steelsales.pojo.employee.EmployeeQuery;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployeeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SteelsaleEmployeeMapper {
    int countByExample(SteelsaleEmployeeExample example);

    int deleteByExample(SteelsaleEmployeeExample example);

    int deleteByPrimaryKey(Integer employeeId);

    int insert(SteelsaleEmployee record);

    int insertSelective(SteelsaleEmployee record);

    List<SteelsaleEmployee> selectByExample(SteelsaleEmployeeExample example);

    SteelsaleEmployee selectByPrimaryKey(Integer employeeId);

    int updateByExampleSelective(@Param("record") SteelsaleEmployee record, @Param("example") SteelsaleEmployeeExample example);

    int updateByExample(@Param("record") SteelsaleEmployee record, @Param("example") SteelsaleEmployeeExample example);

    int updateByPrimaryKeySelective(SteelsaleEmployee record);

    int updateByPrimaryKey(SteelsaleEmployee record);


    /**
     * 模糊查询
     * @param employeeQuery
     */
    List<SteelsaleEmployee> fuzzySelect(@Param("employeeQuery") EmployeeQuery employeeQuery);

    List<String> selectFunctionByEid(Integer employeeId);
}