package com.star.sanyademo.dynamicDatabase;

/**
 * @Author StarC
 * @Date 2021/11/22 19:27
 * @Description:
 */
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String databaseName = DataSourceContextHolder.getDataSource();
        System.out.println(databaseName);
        return DataSourceContextHolder.getDataSource();
    }
}
