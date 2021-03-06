package com.jikeshijian.transaction.controller;

import com.jikeshijian.transaction.common.ChangeAnnotation;
import com.jikeshijian.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program com.jikeshijian.transaction.controller
 * @description 订单控制层
 * @auther Mr.Xiong
 * @create 2021-03-06 14:54:07
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/insertSingle")
    public void insert() {
        orderService.insert();
    }

    @RequestMapping(value = "/insertBatch")
    public void insertBatch() {
        orderService.insertBatch();
    }

    @RequestMapping(value = "/getRequestDBObj")
    public void getRequestDBObj() {
        //假使获取到数据，根据其中一个标记字段确定其处理过后存储的数据库表名为test1
        String table = "test1";
        //在其aop之前修改注解的value
        ChangeAnnotation.change(table);
        String str1 = orderService.selectByKey(2);
        System.out.println(str1);
        System.out.println();

        table = "test2";
        ChangeAnnotation.change(table);
        String str2 = orderService.selectByKey(2);
        System.out.println(str2);
    }
}



