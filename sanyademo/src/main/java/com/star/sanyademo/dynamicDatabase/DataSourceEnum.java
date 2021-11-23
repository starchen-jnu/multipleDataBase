package com.star.sanyademo.dynamicDatabase;

import lombok.Getter;

/**
 * @Author StarC
 * @Date 2021/11/22 19:16
 * @Description:
 */
@Getter
public enum DataSourceEnum {

    DB1("db1DataSource"),
    DB2("db2DataSource"),
    DB3("db3DataSource");
    private String dbName;

    DataSourceEnum(String dbName) {
        this.dbName = dbName;
    }
}
