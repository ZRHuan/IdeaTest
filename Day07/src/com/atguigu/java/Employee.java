package com.atguigu.java;

/**
 * @author zhangruhuan
 * @create 2020-08-03 16:37
 */
public class Employee {
private int age;
private String name;
private MyDate birthday;

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public int getAge() {
        return age;
    }

    public Employee() {
    }

    public Employee(int age, String name, MyDate birthday) {
        this.age = age;
        this.name = name;
        this.birthday = birthday;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}
