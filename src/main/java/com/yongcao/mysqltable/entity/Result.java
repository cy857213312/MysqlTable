package com.yongcao.mysqltable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Result {
    private String chineseName;

    private String physicalName;

    private String primaryKey;

    private List<String> indexes;

    private String database;

    private List<Table> table;

}
