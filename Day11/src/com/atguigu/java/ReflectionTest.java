package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhangruhuan
 * @create 2020-08-13 17:55
 */
public class ReflectionTest {
    //反射之前，对于 Person的操作
    @Test
    public void test1(){
        Person p1 = new Person("Tom", 12);
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

//        在 Person类外部，不可似通过 Person。类的对象调用其内部私有结构
//          比如：name、 shownation()以及私有的构造器
    }
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;

        //1.通过反射，创建 Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person)obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //调用方法

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
//通过反射，可调用 Person类的私有结构的属性。比如：私有的构造器、方法、属性
///调用私有的的造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);


//        调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);


//        调用私有方法

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");
        System.out.println(nation);
    }

    //疑问1:通过直接new的方式就反射的方式部可以调用公共的结构，开发中到底用那个？
    //建议：直接new的方式。
    //什么时候会使用：反射的方式。反射的特征：动态性
    ///疑问2:反射机制与向对象中的封装丝是不是矛盾的？如何看待两个技术？
    ///不矛盾

    //关于java,Lang. Class类的理解
    //1.类的加载过程：
    //程序经过 javac.exe命令后，会生成一个或多个字码文件（. class 结尾），接着我们使用
    //Java.exe命令对某个字码文伴进行解释运行。相当将某个字码文件加表到内存中
    //如载到内存中。此过程就称为类め加載。加载到内存中的类，我们就称为运行的类，此
    //运行时类，就作为 Class的一个实例。
    //2.句话说， Class的实例就对应着一个运行时类。
    //3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可似通过不同的方式
    //来获取此运行时类。|
//获取Class实例的方法（前三种需要掌握）
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性 .class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法  常用
        Class clazz3 = Class.forName("com.atguigu.java.Person");
//        clazz3= Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

//        方式四：使用类的加载器ClassLoader(了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);
    }

}
