package com.ycxy.steelsales.mapper.employeeAndrole;

import com.ycxy.steelsales.pojo.employeeAndrole.SteelsaleEmployeeRole;
import com.ycxy.steelsales.pojo.employeeAndrole.SteelsaleEmployeeRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SteelsaleEmployeeRoleMapper {


    int countByExample(SteelsaleEmployeeRoleExample example);

    int deleteByExample(SteelsaleEmployeeRoleExample example);

    int deleteByPrimaryKey(Integer erId);

    int insert(SteelsaleEmployeeRole record);

    int insertSelective(SteelsaleEmployeeRole record);

    List<SteelsaleEmployeeRole> selectByExample(SteelsaleEmployeeRoleExample example);

    SteelsaleEmployeeRole selectByPrimaryKey(Integer erId);

    int updateByExampleSelective(@Param("record") SteelsaleEmployeeRole record, @Param("example") SteelsaleEmployeeRoleExample example);

    int updateByExample(@Param("record") SteelsaleEmployeeRole record, @Param("example") SteelsaleEmployeeRoleExample example);

    int updateByPrimaryKeySelective(SteelsaleEmployeeRole record);

    int updateByPrimaryKey(SteelsaleEmployeeRole record);

    void updateRoleByEid(@Param("employeeId") Integer employeeId, @Param("eid") Integer eid);

    /**
     * 插入 通过员工id
     * @param employeeId
     * @param roleId
     */
//    void insertByEmployeeId(@Param("employeeId")Integer employeeId, @Param("roleId") Integer roleId);
}