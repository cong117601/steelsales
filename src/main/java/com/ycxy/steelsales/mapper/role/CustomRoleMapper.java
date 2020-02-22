package com.ycxy.steelsales.mapper.role;

import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * 自定义角色mapper
 */
@Mapper
public interface CustomRoleMapper {
    //查出所有角色
    public List<String> selectAllRoleName();
    //根据用户名查找所属角色
    public List<String> selectRoleNameByLoginName(String loginName);



}
