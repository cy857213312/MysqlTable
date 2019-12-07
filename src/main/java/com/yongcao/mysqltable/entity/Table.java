package com.yongcao.mysqltable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Table {

    private String columnName;  //列名

    private String dataType; //数据类型

    private String length;// 长度

    private String isNull; //非空

    private String defaultValue; //默认值

    private String note; //备注
}
