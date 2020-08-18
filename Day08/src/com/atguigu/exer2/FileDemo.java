package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangruhuan
 * @create 2020-08-07 21:24
 */
public class FileDemo {
    @Test
    public void test() throws IOException {
        File file = new File("D:\\io\\io1\\hello.txt");
        String absolutePath = file.getAbsolutePath();
        File file1 = new File(absolutePath, "haha.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }
    }
}
