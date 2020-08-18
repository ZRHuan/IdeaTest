package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author zhangruhuan
 * @create 2020-08-13 20:56
 */
public class MethodTest {
    @Test
    public void test1(){
        Class clazz = Person.class;

//        getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
//         getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    /*
    AXXXX
    权限修饰符   返回值类型   方法名（参数类型1形参名1,:) throws Xxxexception{}
     */
    @Test
    public void test2(){
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
//            /1.获取方法声明的注解
            Annotation[] anno = m.getAnnotations();
            for (Annotation a : anno) {
                System.out.println(a);
            }
//            /2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

//            3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

//            4方法名
            System.out.print(m.getName() );
            System.out.print("(");
//            5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length ==0)){
                for (int i =0; i< parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName()+ " args_" + i + ",");
                }
            }
            System.out.print(")");

//            6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0){
                System.out.print("throws ");
                for (int i = 0;i<exceptionTypes.length;i++){
                    if (i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }
}
