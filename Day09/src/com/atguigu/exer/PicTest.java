package com.atguigu.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhangruhuan
 * @create 2020-08-11 9:13
 */
public class PicTest {

    @Test
    public void test1() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("A.jpg");
            fos = new FileOutputStream("A_secret.jpg");
            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                for (int i=0;i<len;i++){
                    buffer[i] = (byte)(buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void test2() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("A_secret.jpg");
            fos = new FileOutputStream("A_decode.jpg");
            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                for (int i=0;i<len;i++){
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
