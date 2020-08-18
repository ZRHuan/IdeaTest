package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * @author zhangruhuan
 * @create 2020-08-13 19:38
 */
public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        /*
        newInstance 调用此方法创建对应的运行时类的对象,内部调用了运行时类的空参构造器
        1、运行时类必须提供空参的构造器
        2、空参的构造器的访问权限得够 通常设置public
        在 javabean中要求提供一个 public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，认调用 super()时，保证父类有此构造器
        在javabean中要求提供一个public
         */
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }

    //体会反射的动态性
    @Test
    public void test2(){
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.sql.Date";
                break;
            case 2:
                classPath = "com.atguigu.java.Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
