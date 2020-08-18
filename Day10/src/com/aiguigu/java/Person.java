package com.aiguigu.java;

import java.io.Serializable;

/**
 * Person需要满足如下的要求，方可序列化
 * 1.需要实现： Serializable接口
 * 2.当前类提供一个全局常量： serialVersionUID
 * 3.除了Person类需要实现 Serializable接口之外，还必须保证其内部所有属性
 * 必须是可序列化的。
 * @author zhangruhuan
 * @create 2020-08-11 20:55
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 475463534532L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }
}
