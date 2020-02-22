package com.ycxy.steelsales.mapper.role;

import com.ycxy.steelsales.pojo.role.SteelsaleRole;
import com.ycxy.steelsales.pojo.role.SteelsaleRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SteelsaleRoleMapper {
    int countByExample(SteelsaleRoleExample example);

    int deleteByExample(SteelsaleRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(SteelsaleRole record);

    int insertSelective(SteelsaleRole record);

    List<SteelsaleRole> selectByExample(SteelsaleRoleExample example);

    SteelsaleRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") SteelsaleRole record, @Param("example") SteelsaleRoleExample example);

    int updateByExample(@Param("record") SteelsaleRole record, @Param("example") SteelsaleRoleExample example);

    int updateByPrimaryKeySelective(SteelsaleRole record);

    int updateByPrimaryKey(SteelsaleRole record);
}