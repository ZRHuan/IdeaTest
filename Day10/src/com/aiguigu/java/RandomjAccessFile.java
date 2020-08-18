package com.aiguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 *
 * Randomaccessfile的使用
 * 1. Randomaccessfile直继承jqva.Lang.0bect类，实现了Datainput和和Dataoutput：接口
 * 2. Randomaccessfile可以作为一个输入流，又可以作为一个输出流
 * 3.如 Randomaccessfile作为输出流时，写出到的文伴如果不存在，则在执行过程中白动创建
 * 如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情況下，从头覆盖）
 * 4.可以通过相关的操作，实现 Randomaccessfile"插入”数据的效果
 * @author zhangruhuan
 * @create 2020-08-11 21:21
 */
public class RandomjAccessFile {

    @Test
    public void test() throws IOException {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("A.jpg"), "r");
            raf2 = new RandomAccessFile(new File("B.jpg"), "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.seek(3);//指针调到角标为3的位置
        raf1.write("xyz".getBytes());
        raf1.close();
    }


    /*
    使用RandomAccessFile实现插入效果
     */

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.seek(3);//指针调到角标为3的位置
//保存指针3后面的所有数据到 stringbuilder中
        StringBuilder builder = new StringBuilder((int)(new File("hello.txt").length()));
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer,0,len));
        }

        ///调回指针，写入"xyz
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        ///将 stringbuilder中的数据写入到文件中

        raf1.write(builder.toString().getBytes());
        raf1.close();
    }
}
