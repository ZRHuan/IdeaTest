package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**1.缓冲流：
    * Bufferedinputstream
    * Bufferedoutputstream
    * Bufferedreader
    * Bufferedwriter
 *
 *
 * @author zhangruhuan
 * @create 2020-08-08 21:17
 */
public class BufferedTest {
    @Test
    public void testBufferedReaderBufferedWriter() throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));
//方式一
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf))!= -1 ){
//                bw.write(cbuf,0,len);
//                bw.flush();
//            }

 //方式2
            String data;
            while((data = br.readLine())!= null){
                bw.write(data);//data中不含换行符
                bw.newLine();//提供换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null){
                bw.close();

            }
            if (bw != null){
                br.close();

            }
        }

    }




    @Test
    public void BufferedStreamTest() throws FileNotFoundException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("E:\\Videos\\8K60fps.webm");
            File destFile = new File("E:\\Videos\\8K60fps.webm");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer))!= -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //4.资源关
        //要求：先关外层的流，再关内层的
//        bos.close();
//        bis.close();
        //说明：只需要考虑外层即可，内层关闭可省略
//        fos.close();
//        fis.close();
    }
public void copyFileBuffered(String srcPath,String destPath){
    FileInputStream fis = null;
    FileOutputStream fos = null;
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    try {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        fis = new FileInputStream(srcFile);
        fos = new FileOutputStream(destFile);

        bis = new BufferedInputStream(fis);
        bos = new BufferedOutputStream(fos);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer))!= -1){
            bos.write(buffer,0,len);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (bis != null){
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bos != null){
            try {
                bos.close();
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
    String destPath="E:\\Videos\\new1_8K60fps.webm";
    copyFileBuffered(srcPath,destPath);

    long end = System.currentTimeMillis();
    System.out.println("复制文件花费的时间为"+(end-start));
}



}
