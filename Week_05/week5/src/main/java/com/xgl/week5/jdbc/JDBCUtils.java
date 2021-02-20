package com.xgl.week5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program com.xgl.week5.jdbc
 * @description jdbc连接工具
 * @auther Mr.Xiong
 * @create 2021-02-20 17:1
 */
public class JDBCUtils {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String url = "jdbc:mysql://127.0.0.1:3306/mysql_learn?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false" ;
        final String name = "com.mysql.cj.jdbc.Driver" ;
        final String user = "root" ;
        final String password = "571314" ;
        Connection conn;
        Class.forName(name);
        //指定连接类型
        conn = DriverManager.getConnection(url, user, password);
        //获取连接
        if (conn!= null ) {
            System.out.println( "获取连接成功" );
            //insert(conn);
            //delete(conn);
            //update(conn);
            select(conn);
        } else {
            System.out.println( "获取连接失败" );
        }

    }

    public static void insert(Connection conn) {
        // sql前缀
        String sql = "INSERT INTO people(name,age,home_adress) VALUES('test', 10, 'bj') " ;
        try {
            // 设置事务为非自动提交
            conn.setAutoCommit( false );
            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            // 执行操作
            pst.execute();
            // 提交事务
            conn.commit();
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( "插入完成" );
    }

    public static void delete(Connection conn) {
        // sql前缀
        String sql = "delete from people where name = 'test' " ;
        try {
            // 设置事务为非自动提交
            conn.setAutoCommit( false );
            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            // 执行操作
            pst.execute();
            // 提交事务
            conn.commit();
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( "删除完成" );
    }

    public static void update(Connection conn) {
        // sql前缀
        String sql = "update people set home_adress = 'xiugai' where name ='1同学' " ;
        try {
            // 设置事务为非自动提交
            conn.setAutoCommit( false );
            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            // 执行操作
            pst.execute();
            // 提交事务
            conn.commit();
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( "更新完成" );
    }

    public static void select(Connection conn) {
        // sql前缀
        String sql = "select * from people where name = '1同学' " ;
        try {
            // 设置事务为非自动提交
            conn.setAutoCommit( false );
            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            // 执行操作
            pst.execute();
            // 提交事务
            conn.commit();
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( "查询完成" );
    }
}
