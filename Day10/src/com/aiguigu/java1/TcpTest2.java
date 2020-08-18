package com.aiguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *
 * 实现TCP的网编程
 * 例题2:客户端发送文件给服务端，服务端将文件保存在本她。
 * @author zhangruhuan
 * @create 2020-08-12 21:02
 */
public class TcpTest2 {
@Test
    public void TCPtest2() throws IOException {

    Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);

    OutputStream os = socket.getOutputStream();

    FileInputStream fis = new FileInputStream(new File("A.jpg"));

    byte[] buffer = new byte[1024];
    int len;
    while((len = fis.read(buffer)) != -1){
        os.write(buffer,0,len);
    }
    fis.close();
    os.close();
    socket.close();
}

@Test
    public void server() throws IOException {
    ServerSocket ss = new ServerSocket(9090);

    Socket socket = ss.accept();

    InputStream is = socket.getInputStream();

    FileOutputStream fos = new FileOutputStream(new File("ABBB.jpg"));

    byte[] buffer = new byte[1024];
    int len;
    while ((len=is.read(buffer))!=-1){
        fos.write(buffer,0,len);
    }
    fos.close();
    is.close();
    socket.close();
    ss.close();
}
}
