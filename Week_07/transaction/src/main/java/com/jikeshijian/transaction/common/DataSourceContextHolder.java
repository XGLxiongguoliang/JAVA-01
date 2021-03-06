package com.jikeshijian.transaction.common;

/**
 * @program com.jikeshijian.transaction
 * @description 存储对应线程池的数据源
 * @auther Mr.Xiong
 * @create 2021-03-06 18:28:36
 */
public class DataSourceContextHolder {
    public static final String DEFAULT_DS = "test1";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDB(String dbType) {
        System.out.println("切换到{" + dbType + "}数据源");
        contextHolder.set(dbType);
    }

    public static String getDB() {
        return contextHolder.get();
    }

    public static void clearDB() {
        contextHolder.remove();
    }
}
