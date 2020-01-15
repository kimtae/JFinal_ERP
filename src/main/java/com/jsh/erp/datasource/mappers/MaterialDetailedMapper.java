package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.MaterialDetailed;
import com.jsh.erp.datasource.entities.MaterialDetailedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialDetailedMapper {
    long countByExample(MaterialDetailedExample example);

    int deleteByExample(MaterialDetailedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaterialDetailed record);

    int insertSelective(MaterialDetailed record);

    List<MaterialDetailed> selectByExample(MaterialDetailedExample example);

    MaterialDetailed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaterialDetailed record, @Param("example") MaterialDetailedExample example);

    int updateByExample(@Param("record") MaterialDetailed record, @Param("example") MaterialDetailedExample example);

    int updateByPrimaryKeySelective(MaterialDetailed record);

    int updateByPrimaryKey(MaterialDetailed record);
}