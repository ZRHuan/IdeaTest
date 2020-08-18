package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhangruhuan
 * @create 2020-08-13 19:15
 */
public class ClassLoaderTest {
    @Test
    public void test(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
//        调用系统类加载器的 getparent():获取扩展类加载器
        System.out.println(classLoader.getParent());
//        /调用扩展类加载器的 getparent():无法获取引导类加载器
//      引导类加载器主要负责加载java的核心类库，无法加载自定义类的
        System.out.println(classLoader.getParent().getParent());

    }
    @Test
    public  void test2() throws IOException {
        Properties pros = new Properties();

        //此时的文件默认在当前的module下
        //读取配置文件的方式一
//        FileInputStream fis = new FileInputStream("src\\jdbc.properties");
//        pros.load(fis);
//读取配置文件的方式二：使用 classloader
//配置文件认识别为：当前 module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user +",password = " + password);
    }
}
