package com.yongcao.mysqltable.mapper;


import com.yongcao.mysqltable.entity.Index;
import com.yongcao.mysqltable.entity.Result;
import com.yongcao.mysqltable.entity.Table;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ResultMapper {

    @Select("SELECT TABLE_NAME AS physicalName,TABLE_COMMENT AS  chineseName\n" +
            "FROM information_schema.TABLES\n" +
            "WHERE table_schema=#{database}")
    List<Result> allTableName(@Param("database") String database);

    @Select("show index from ${table}")
    List<Index> allIndex(@Param("table") String table);

    @Select("SELECT COLUMN_NAME AS columnName,COLUMN_TYPE as dataType,  \n" +
            "  CHARACTER_MAXIMUM_LENGTH as length, IS_NULLABLE as isNull,  \n" +
            "  COLUMN_DEFAULT as defaultValue, COLUMN_COMMENT as note   \n" +
            "FROM INFORMATION_SCHEMA.COLUMNS \n" +
            "where table_name  = #{tableName} AND TABLE_SCHEMA = #{database}")
    List<Table> tableData(@Param("database") String database,@Param("tableName") String tableName);

}
