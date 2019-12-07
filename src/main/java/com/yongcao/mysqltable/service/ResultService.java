package com.yongcao.mysqltable.service;

import com.yongcao.mysqltable.entity.Index;
import com.yongcao.mysqltable.entity.Result;
import com.yongcao.mysqltable.entity.Table;


import java.util.List;


public interface ResultService {

    List<Result> allTableName();

    List<Index> allIndex(String table);

    List<Table> tableData(String database, String tableName);

}
