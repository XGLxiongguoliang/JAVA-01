package com.xgl.week5.loadobject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program com.xgl.week5.loadobject
 * @description xml加载类
 * @auther Mr.Xiong
 * @create 2021-02-20 21:48
 */
public class Xml_Load {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springApplication.xml");
        Student xgl = (Student) context.getBean("xgl");
        System.out.println("xgl......" + xgl);
    }
}
