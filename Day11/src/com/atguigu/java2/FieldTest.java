package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author zhangruhuan
 * @create 2020-08-13 20:34
 */
public class FieldTest {
    @Test
    public void test1(){
        Class clazz = Person.class;
//        获取属性结构
//// getfields():获取当前运行时类及父类中声明为public访向权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("*************");
//        getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] dF = clazz.getDeclaredFields();
        for (Field f : dF) {
            System.out.println(f);
        }
    }
//    权限修饰符   数据类型    变量名
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
///             1.权限修饰符
            int modifier = f.getModifiers();
            System.out.println(Modifier.toString(modifier) + "\t");

//         2.数据类型
            Class type = f.getType();
            System.out.println(type.getName() + "\t");
//            3.变量名
            String fName = f.getName();
            System.out.println(fName);
            System.out.println();
        }
    }

}
