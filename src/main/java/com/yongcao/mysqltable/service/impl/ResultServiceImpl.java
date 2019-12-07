package com.yongcao.mysqltable.service.impl;

import com.yongcao.mysqltable.entity.Index;
import com.yongcao.mysqltable.entity.Result;
import com.yongcao.mysqltable.entity.Table;
import com.yongcao.mysqltable.mapper.ResultMapper;
import com.yongcao.mysqltable.service.ResultService;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Value("${database.name}")
    private String database;

    @Autowired
    ResultMapper resultMapper;

    @Override
    public List<Result> allTableName() {
        List<Result> results = resultMapper.allTableName(database);

        for (Result re:results) {
            List<String> string=new ArrayList<>();
            List<Index> indices = allIndex(re.getPhysicalName()); //查询所有的主键和索引
            for (Index in:indices) {
                if(in.getKey_name().equals("PRIMARY")){
                    re.setPrimaryKey(in.getColumn_name());         //记录主键
                }else{
                    string.add(in.getColumn_name());
                }
            }
            re.setIndexes(string);                                 //记录索引
            re.setDatabase(database);                               //记录数据库

            List<Table> table = tableData(re.getDatabase(), re.getPhysicalName());
            re.setTable(table);
        }
        return results;
    }

    @Override
    public List<Index> allIndex(String table) {
        return resultMapper.allIndex(table);
    }

    @Override
    public List<Table> tableData(String database, String tableName) {
        return resultMapper.tableData(database,tableName);
    }

}
