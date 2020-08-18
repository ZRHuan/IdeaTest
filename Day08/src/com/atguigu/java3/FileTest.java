package com.atguigu.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangruhuan
 * @create 2020-08-07 20:37
 */
public class FileTest {
    @Test
 public void test(){
        File file1 = new File("hello.txt");
        System.out.println(file1);



    }

@Test
    public void test2(){
    File file1 = new File("hello.txt");
    File file2 = new File("d:\\io\\hi/txt");
    System.out.println(file1.getAbsolutePath());
    System.out.println(file1.getPath());
    System.out.println(file1.getAbsoluteFile());



}
@Test
    public void test6() throws IOException {
    File file1 = new File("Hi.txt");
    if(!file1.exists()){
        file1.createNewFile();
        System.out.println("创建成功");
    }else {
        file1.delete();
        System.out.println("删除成功");
    }
}

@Test
    public void test7(){
    File file1 = new File("d:\\io\\io1");
    if (file1.mkdir()){
        System.out.println("1");
    }
    File file2 = new File("e:\\io\\io1");
    if (file2.mkdirs()){
        System.out.println("Yes");
    }
}

}
