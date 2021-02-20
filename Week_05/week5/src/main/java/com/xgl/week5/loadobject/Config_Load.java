package com.xgl.week5.loadobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @program com.xgl.week5.loadobject
 * @description 自动装载类
 * @auther Mr.Xiong
 * @create 2021-02-20 20:50
 */
@Configuration
public class Config_Load {

    @Bean
    public Student autoLoadStudent() {
        return new Student("test", "10");
    }
}
