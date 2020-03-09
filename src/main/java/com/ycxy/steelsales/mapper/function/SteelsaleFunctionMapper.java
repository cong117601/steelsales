package com.ycxy.steelsales.mapper.function;

import com.ycxy.steelsales.pojo.function.SteelsaleFunction;
import com.ycxy.steelsales.pojo.function.SteelsaleFunctionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SteelsaleFunctionMapper {
    int countByExample(SteelsaleFunctionExample example);

    int deleteByExample(SteelsaleFunctionExample example);

    int deleteByPrimaryKey(Integer functionId);

    int insert(SteelsaleFunction record);

    int insertSelective(SteelsaleFunction record);

    List<SteelsaleFunction> selectByExample(SteelsaleFunctionExample example);

    SteelsaleFunction selectByPrimaryKey(Integer functionId);

    int updateByExampleSelective(@Param("record") SteelsaleFunction record, @Param("example") SteelsaleFunctionExample example);

    int updateByExample(@Param("record") SteelsaleFunction record, @Param("example") SteelsaleFunctionExample example);

    int updateByPrimaryKeySelective(SteelsaleFunction record);

    int updateByPrimaryKey(SteelsaleFunction record);

    /**
     * 查找所有权限
     * @return
     */
    List<SteelsaleFunction> selectAll();
}