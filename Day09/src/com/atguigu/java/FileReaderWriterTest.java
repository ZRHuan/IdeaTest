package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author zhangruhuan
 * @create 2020-08-07 21:54
 */
public class FileReaderWriterTest {
    @Test
    public void testFileReader1()  {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
//                for (int i = 0;i < cbuf.length;i++){
//                    System.out.print(cbuf[i]);
//                }
                for (int i = 0;i < len;i++){
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void testFileWriter() throws IOException {
        File file = new File("hello1.txt");
        FileWriter fw = new FileWriter(file,true);
        fw.write("I have e dream\n!");
        fw.write("I have e dream  too!\n");
        fw.close();
    }

    @Test
    public void testFileReaderFileWriter() throws IOException {
        FileReader fr = null;
        FileWriter fw = null;
        try {
//            File srcfile = new File("hello.txt");
//            File destfile = new File("hello2.txt");


            File srcfile = new File("hello.txt");
            File destfile = new File("hello2.txt");


            fr = new FileReader(srcfile);
            fw = new FileWriter(destfile);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf))!= -1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null){
                    fw.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            fr.close();
        }



    }
}
