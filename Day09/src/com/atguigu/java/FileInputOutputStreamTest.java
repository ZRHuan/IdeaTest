package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 文本文件使用字符流
 * 非文本文件使用字节流
 *
 *
 * @author zhangruhuan
 * @create 2020-08-08 20:42
 */
public class FileInputOutputStreamTest {
    @Test

    public void test() throws IOException {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!= null)
                fis.close();

        }
    }



    @Test
    public void testFileInputOutputStream() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File("A.jpg");
            File destfile = new File("B.jpg");

            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer))!= -1){
    //            String str = new String(buffer, 0, len);

                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        fis.close();
//        fos.close();

    }
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File(srcPath);
            File destfile = new File(destPath);

            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer))!= -1){
                //            String str = new String(buffer, 0, len);

                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "E:\\Videos\\8K60fps.webm";
        String destPath="E:\\Videos\\new_8K60fps.webm";
        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制文件花费的时间为"+(end-start));
    }
}
