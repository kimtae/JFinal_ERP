package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.MaterialDetailedCC;
import com.jsh.erp.datasource.entities.MaterialDetailedCCExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialDetailedCCMapper {
    long countByExample(MaterialDetailedCCExample example);

    int deleteByExample(MaterialDetailedCCExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaterialDetailedCC record);

    int insertSelective(MaterialDetailedCC record);

    List<MaterialDetailedCC> selectByExample(MaterialDetailedCCExample example);

    MaterialDetailedCC selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaterialDetailedCC record, @Param("example") MaterialDetailedCCExample example);

    int updateByExample(@Param("record") MaterialDetailedCC record, @Param("example") MaterialDetailedCCExample example);

    int updateByPrimaryKeySelective(MaterialDetailedCC record);

    int updateByPrimaryKey(MaterialDetailedCC record);
}