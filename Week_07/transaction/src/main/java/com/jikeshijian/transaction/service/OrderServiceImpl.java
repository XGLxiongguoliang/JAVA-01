package com.jikeshijian.transaction.service;

import com.jikeshijian.transaction.annotation.DS;
import com.jikeshijian.transaction.domain.Order;
import com.jikeshijian.transaction.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program com.jikeshijian.transaction.service
 * @description 订单实现类
 * @auther Mr.Xiong
 * @create 2021-03-06 14:32:44
 */
@Service
public class OrderServiceImpl implements  OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void insert() {

        Long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000 ; i++) {
            Order order = new Order();
            order.setOrderNumber("订单编号" + i);
            order.setSellAccount("卖家");
            order.setBuyAccount("买家");
            order.setProductNumber("商品编号" + i);
            order.setBuyNum(i);
            order.setPrice(100D);
            order.setDetail("订单哦");
            order.setOrderTime(new Date());
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            System.out.println("插入第---" + i + "---条");
            orderMapper.insert(order);
        }

        Long end = System.currentTimeMillis();

        System.out.println("单条插入100万数据到数据库使用总时长：-------" + (end - start)/1000 + "-----s");
    }

    @Override
    public void insertBatch() {

        Long start = System.currentTimeMillis();

        List<Order> orderList = new ArrayList<>();

        for (int i = 0; i < 9900000 ; i++) {
            Order order = new Order();
            order.setOrderNumber("订单编号" + i);
            order.setSellAccount("卖家");
            order.setBuyAccount("买家");
            order.setProductNumber("商品编号" + i);
            order.setBuyNum(i);
            order.setPrice(100D);
            order.setDetail("订单哦");
            order.setOrderTime(new Date());
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            System.out.println("生成第---" + i + "---条");

            orderList.add(order);
        }

        orderMapper.insertBatch(orderList);

        Long end = System.currentTimeMillis();

        System.out.println("批量插入100万数据到数据库使用总时长：-------" + (end - start)/1000 + "-----s");
    }

    @Override
    @DS
    public String selectByKey(Integer id) {
        return orderMapper.selectByKey(id);
    }

}
