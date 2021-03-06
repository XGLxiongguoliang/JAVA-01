package com.jikeshijian.transaction.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @program com.jikeshijian.transaction
 * @description 数据源类
 * @auther Mr.Xiong
 * @create 2021-03-06 18:33:21
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为" + DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
