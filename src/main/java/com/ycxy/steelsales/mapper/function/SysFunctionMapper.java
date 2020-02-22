package com.ycxy.steelsales.mapper.function;

import com.ycxy.steelsales.pojo.function.SysFunction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysFunctionMapper {

    List<SysFunction> seleteUserFunctionByUsername(String loginName);
}
