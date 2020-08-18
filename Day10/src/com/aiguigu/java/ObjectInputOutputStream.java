package com.aiguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * @author zhangruhuan
 * @create 2020-08-11 20:45
 */
public class ObjectInputOutputStream {

    /*
     序列化过程将内存中的java对象保存到磁盘中
     */
    @Test
    public void testOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();

            oos.writeObject(new Person("zhang",123));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /*
    反序列化 将磁盘中的对象还原为内存中的
     */
    @Test
    public void testInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("data.dat"));

            Object obj = ois.readObject();
            String str = (String)obj;
            System.out.println(str);

            Object o = ois.readObject();
            Person s = (Person)o;
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
