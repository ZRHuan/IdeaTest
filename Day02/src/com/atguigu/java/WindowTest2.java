package com.atguigu.java;

/**
 * @author zhangruhuan
 * @create 2020-06-05-15:57
 */

/**
 * @author zhangruhuan
 * @create 2020-05-29-15:26
 *
 *
 *  * 使用同步代码块解决继承 Thread类的方式的线程安全问题
 *  * 例子：创建三个窗口卖票，总票数为8张。使用继承 Thread类的方式
 *
 */
class Window2 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();//继承方式不是共享数据的，所以只设一个Object
    @Override
    public void run() {
        while (true) {
            synchronized (Window2.class) {//Window2 也是对象
                if (ticket > 0) {
                    System.out.println(getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1= new Window2();
        Window2 t2= new Window2();
        Window2 t3= new Window2();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
