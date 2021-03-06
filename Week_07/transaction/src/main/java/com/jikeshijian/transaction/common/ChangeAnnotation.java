package com.jikeshijian.transaction.common;

import com.jikeshijian.transaction.annotation.DS;
import com.jikeshijian.transaction.service.OrderServiceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @program com.jikeshijian.transaction.annotation
 * @description 修改数据库注解的值
 * @auther Mr.Xiong
 * @create 2021-03-06 18:15:57
 */
public class ChangeAnnotation {
    public static void change(String table) {
        String annotation = table;
        try {
            Method[] methods = OrderServiceImpl.class.getMethods();
            int i = 1;
            while (methods[i].getAnnotation(DS.class) != null) {
                DS ds = methods[i].getAnnotation(DS.class);
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(ds);
                Field value = invocationHandler.getClass().getDeclaredField("memberValues");
                value.setAccessible(true);
                Map<String, Object> memberValues = (Map<String, Object>) value.get(invocationHandler);
                String val = (String) memberValues.get("value");
                System.out.println("改变前：" + val);
                val = annotation;
                memberValues.put("value", val);
                System.out.println("改变后：" + ds.value());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
