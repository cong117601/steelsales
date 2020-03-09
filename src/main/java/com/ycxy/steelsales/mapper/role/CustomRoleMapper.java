package com.ycxy.steelsales.mapper.role;

import com.ycxy.steelsales.pojo.role.SteelsaleRole;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

/**
 * 自定义角色mapper
 */
@Mapper
public interface CustomRoleMapper {
    /**
     * 查出所有角色名
     * @return
     */
    public List<String> selectAllRoleName();

    /**
     * 根据用户名查找所属角色
     * @param loginName
     * @return
     */
    public List<String> selectRoleNameByLoginName(String loginName);

    /**
     * 查询所有角色
     * @return
     */
    List<SteelsaleRole> selectAll();

    /***
     * 查找用户所属角色
     * @param id
     * @return
     */
    List<Integer> selectRoleIdByEid(Integer id);

    List<SteelsaleRole> selectAlls(Map map);
}
