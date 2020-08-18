package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author zhangruhuan
 * @create 2020-08-11 9:38
 */
public class InputStreamReaderTest {
    @Test
    public void InputStreamReaderTest() throws IOException {
        FileInputStream fis = new FileInputStream("1.txt");
///参数2指明了字行集，具体使用哪个字符集，取决于文件bcp,txt保存时使用的字符集
//Inputstreamreader isr new Inputstreamreader(fis, charsetname: "UTF-8"); /
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        char[]  cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf))!= -1){
            String str = new String(cbuf, 0, len);
            System.out.println(str);
        }
        isr.close();

    }

    @Test
    public void test2() throws IOException {
        //1造文件、造流
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file1 = new File("1.txt");
            File file2 = new File("1_gbk.txt");
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis, "utf-8");
            osw = new OutputStreamWriter(fos, "gbk");
            //2.读写过程
            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!= null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //关闭资源
//        isr.close();
//        osw.close();
    }
}
