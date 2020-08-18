package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**调用运行时类中指定结构：属性  方法    构造器
 * @author zhangruhuan
 * @create 2020-08-17 17:09
 */
public class ReflectionTest {
    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;
//创建运行时类的对象
        Person p = (Person) clazz.newInstance();
//        获取指定的属性:public的
        Field id = clazz.getField("id");
/*
设置当前属性的值
set():参数1:指明設置个对象的属性   参数2:将此属性值设置为多少
 */
        id.set(p,1001);


        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    /*
    如何操作运行时类中的指定的属性-需要掌握
     */
    @Test
    public void testField1() throws Exception {
        Class clazz = Person.class;
//创建运行时类的对象
        Person p = (Person) clazz.newInstance();
//// 1.getDeclaredField( String Fieldname):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
//        2. 保证的当前属性可以访问
        name.setAccessible(true);
//        获取、设置指定对象的此属性值
        name.set(p,"Tom");

        System.out.println(name.get(p));
    }
    /*
    如何调用运行时类中的指定的方法-需要掌握
     */

    @Test
    public void testMethod() throws Exception{
        Class clazz = Person.class;
//     创建运行时类的对象
        Person p = (Person) clazz.newInstance();
/*
        1.获取指定的某个方法
        getDeclaredMethod():参数1:指明获取的方法的名称    参数2:指明获取的方法的形参列表
 */
        Method show = clazz.getDeclaredMethod("show", String.class);
        //        2. 保证的当前属性可以访问
        show.setAccessible(true);
//        2.调用方法的 invoke():参数1:方法的调用者    参数2:给方法形参赋值的实参
//      invoke()的返回值即为对应类中调用的方法的返回值
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

        System.out.println("**********如何调用·静态方法***********");
//        public static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

//        //如果调用的运行时类中的方法没有返回值，此 invoke()返null
        Object returnVal = showDesc.invoke(Person.class);//Person.class也可以写null
        System.out.println(returnVal);
    }
    /*
    如何调用运行时类中的指定的构造器-
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;
//          //private Person(String name)
//          /1.获取指定的构造器
//        getDeclaredConstructor():参数：指明构造器的参数列表
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
//        2. 保证的当前属性可以访问
        constructor.setAccessible(true);
//      调用此构造器创建运行时类的对象
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);
    }
}
