package com.xgl.week5.loadobject;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program com.xgl.week5.loadobject
 * @description 学生类
 * @auther Mr.Xiong
 * @create 2021-02-20 21:25
 */
public class Student {

    private String name;
    private String age;

    public Student() {

    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
        print();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void print() {
        System.out.println("student..........");
    }
}
