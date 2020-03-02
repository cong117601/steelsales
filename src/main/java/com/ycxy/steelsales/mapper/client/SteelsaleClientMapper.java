package com.ycxy.steelsales.mapper.client;

import com.ycxy.steelsales.pojo.client.SteelsaleClient;
import com.ycxy.steelsales.pojo.client.SteelsaleClientExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SteelsaleClientMapper {
    int countByExample(SteelsaleClientExample example);

    int deleteByExample(SteelsaleClientExample example);

    int deleteByPrimaryKey(Integer clientId);

    int insert(SteelsaleClient record);

    int insertSelective(SteelsaleClient record);

    List<SteelsaleClient> selectByExample(SteelsaleClientExample example);

    SteelsaleClient selectByPrimaryKey(Integer clientId);

    int updateByExampleSelective(@Param("record") SteelsaleClient record, @Param("example") SteelsaleClientExample example);

    int updateByExample(@Param("record") SteelsaleClient record, @Param("example") SteelsaleClientExample example);

    int updateByPrimaryKeySelective(SteelsaleClient record);

    int updateByPrimaryKey(SteelsaleClient record);

    /**
     * 模糊查询
     * @param map
     * @return
     */
    List<SteelsaleClient> fuzzyQuery(Map map);
}