package com.yongcao.mysqltable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Index {
    private String Key_name;
    private String Column_name;
}
