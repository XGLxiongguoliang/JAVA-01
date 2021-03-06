
package com.jikeshijian.transaction.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @program com.example.network.temp
 * @description 导入mysql数据
 * @auther Mr.Xiong
 * @create 2020-05-15 09:
 */

public class MysqlLearn {
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
            insert(conn);
        } else {
            System.out.println( "获取连接失败" );
        }

    }

    public static void insert(Connection conn) {
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd");
        String time = formater.format(new Date());
        System.out.println(time);

        //ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        //开始时间
        Long begin = System.currentTimeMillis();
        //sql前
        String prefix = "INSERT INTO tb_order(order_number,sell_account,buy_account,product_number,buy_num,price,detail,order_time,create_time,update_time) VALUES " ;

        try {
            //sql后缀
            StringBuffer suffix;
            //设置事务为非自动提交
            conn.setAutoCommit( false );
            //比起st，pst会更好些
            PreparedStatement pst = conn.prepareStatement(prefix);
            //外层循环，总提交事务次数
            for ( int i = 1 ; i <= 2 ; i++) {
                suffix = new StringBuffer();
                //第j次提交
                for ( int j = 1 ; j <= 500000 ; j++) {
                    //构建SQL后缀
                    suffix.append( "('" +
                            "订单编号" + i*j +
                            "','" + "卖家" +
                            "','" + "买家" +
                            "','" + "商品编号" + i*j +
                            "','" + i*j +
                            "','" + 100D +
                            "','" + "订单哦" +
                            "','" + time +
                            "','" + time +
                            "','" + time + "'" +
                            "),"
                    );
                }
                //构建完整SQL
                String sql = prefix + suffix.substring( 0 , suffix.length() - 1 );
                //添加执行SQL
                pst.addBatch(sql);
                //执行操作
                pst.executeBatch();
                //提交事务
                conn.commit();
            }
            //关闭连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //结束时间
        Long end = System.currentTimeMillis();

        // 耗时
        System.out.println( "100万条数据插入花费时间 : " + (end - begin) / 1000 + " s" );
        System.out.println( "插入完成" );
    }


}

