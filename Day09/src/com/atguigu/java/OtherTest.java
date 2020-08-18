package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author zhangruhuan
 * @create 2020-08-11 14:59
 */
public class OtherTest {
    @Test
    public void tets3() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));
            dos.writeUTF("张三");
            dos.flush();
            dos.writeInt(23);
            dos.writeBoolean(true);
            dos.flush();//刷新操作，将内存中的数据写入文件
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Test
    public void Test3() throws IOException {
        //将文件中存信的基本数据类型变量和字符宇读取到内存中，保存在变量中
        //注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致：
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        System.out.println("name = " + name);
        System.out.println("name = " + age);
        System.out.println("isMale = " + isMale);

    }
}
