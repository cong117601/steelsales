package com.ycxy.steelsales.mapper.log;

import com.ycxy.steelsales.pojo.log.SteelsaleLog;
import com.ycxy.steelsales.pojo.log.SteelsaleLogExample;
import com.ycxy.steelsales.pojo.log.SteelsaleLogWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SteelsaleLogMapper {
    int countByExample(SteelsaleLogExample example);

    int deleteByExample(SteelsaleLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SteelsaleLogWithBLOBs record);

    int insertSelective(SteelsaleLogWithBLOBs record);

    List<SteelsaleLogWithBLOBs> selectByExampleWithBLOBs(SteelsaleLogExample example);

    List<SteelsaleLog> selectByExample(SteelsaleLogExample example);

    SteelsaleLogWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SteelsaleLogWithBLOBs record, @Param("example") SteelsaleLogExample example);

    int updateByExampleWithBLOBs(@Param("record") SteelsaleLogWithBLOBs record, @Param("example") SteelsaleLogExample example);

    int updateByExample(@Param("record") SteelsaleLog record, @Param("example") SteelsaleLogExample example);

    int updateByPrimaryKeySelective(SteelsaleLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SteelsaleLogWithBLOBs record);

    int updateByPrimaryKey(SteelsaleLog record);


}