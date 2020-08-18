package com.aiguigu.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangruhuan
 * @create 2020-08-12 20:28
 */
public class TcpTest1 {

//    客户端
    @Test
    public void client() throws IOException {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建 Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
//            2.获取一个出流，用于输出数据
            os = socket.getOutputStream();

//            3.写出数据的操作
            os.write("你好，我是客户端mm".getBytes());
//            //4.资源的关闭
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



//    服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
//            1.建服务器端的 Serversocket，指明白己的端号
            ss = new ServerSocket(8899);
//              2.调用 accept()表示接收来自于客户端6的 socket
            socket = ss.accept();
//              3.获取输入流
            is = socket.getInputStream();
//不建议这样写，可能出现乱码
//        byte[] buffer = new byte[20];
//        int len;
//        while((len = is.read(buffer)) != -1){
//            String str = new String(buffer, 0, len);
//            System.out.println(str);
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);

            }
            System.out.println(baos.toString());
            System.out.println(socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos!=null){

                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null){

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss!=null){

                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
