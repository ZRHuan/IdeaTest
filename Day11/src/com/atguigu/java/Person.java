package com.atguigu.java;

/**
 * @author zhangruhuan
 * @create 2020-08-13 17:50
 */
public class Person {
    private String name;
    public int age;

    public Person() {
        System.out.println("Person....");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void show(){
        System.out.println("你好，我是一个人");
    }
    private String showNation(String nation){
        System.out.println("我的国籍是： " + nation);
        return nation;
    }
}
