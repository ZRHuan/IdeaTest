package com.atguigu.java1;

/**
 * @author zhangruhuan
 * @create 2020-08-13 20:05
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
        private String name;
        int age;
        public int id;
        public Person(){}
@MyAnnotation
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是" + nation);
        return nation;
    }
    public String display(String interests) throws NullPointerException,ClassCastException{
            return interests;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}
