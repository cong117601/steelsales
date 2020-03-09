package com.ycxy.steelsales.mapper.roleAndFunction;

import com.ycxy.steelsales.pojo.roleAndFunction.SteelsaleRoleFunction;
import com.ycxy.steelsales.pojo.roleAndFunction.SteelsaleRoleFunctionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SteelsaleRoleFunctionMapper {
    int countByExample(SteelsaleRoleFunctionExample example);

    int deleteByExample(SteelsaleRoleFunctionExample example);

    int deleteByPrimaryKey(Integer rfId);

    int insert(SteelsaleRoleFunction record);

    int insertSelective(SteelsaleRoleFunction record);

    List<SteelsaleRoleFunction> selectByExample(SteelsaleRoleFunctionExample example);

    SteelsaleRoleFunction selectByPrimaryKey(Integer rfId);

    int updateByExampleSelective(@Param("record") SteelsaleRoleFunction record, @Param("example") SteelsaleRoleFunctionExample example);

    int updateByExample(@Param("record") SteelsaleRoleFunction record, @Param("example") SteelsaleRoleFunctionExample example);

    int updateByPrimaryKeySelective(SteelsaleRoleFunction record);

    int updateByPrimaryKey(SteelsaleRoleFunction record);

    /**
     * 修改权限时 重新插入
     * @param roleId
     * @param integers
     */
    void insertFunction(@Param("roleId") Integer roleId,@Param("integers") List<Integer> integers);
}