package com.atguigu.java;

/**
 * @author zhangruhuan
 * @create 2020-06-06-10:22
 */
class Window4 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();//继承方式不是共享数据的，所以只设一个Object

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show() {//同步监视器： Window4.class 唯一
        //private synchronized void show()    同步监视器：t1，t2，t3.此种解决方式是错误的
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
