package com.atguigu.Java2;

/**
 *
 *
 * 线程通信的例子：使用两个线程打印1-108.线程1，线程2交替打印
 *
 * 涉及到的三个方法
 * wait（）：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify（）：一且执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的线程
 * notifyall（）：一旦执行此方法，就会唤醒所有被wait的线程。
 *说明：
 * 1.wait（），notify（）， notifyAll（）三个方法必须使用在同步代码块或同步方法中
 * 2.wait（）， notify（）， notifyALl（）三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 * 否则，会出现 ILLegaLMonitorstateException异常
 *
 * 面试题： sLeep（）和wait（）的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2.不同点：1）两个方法声明的位置不同： Thread.类中声明 sLeep（），0bject类中声wait（）
 *          2）调用的要求不同： sLeep（）可以在任何需要的场景下调用。Wait（）必须使用在同步代码块或同步方法中
 *          3）同步监视器：如果两个方法都使用在同步代码块或同步方法中， sLeep（）不会释放锁，wait（）会释放锁。
 *          sleep在阻塞时间结束后自动唤醒,wait需要notify唤醒
 * @author zhangruhuan
 * @create 2020-06-06-15:49
 */


class Number implements Runnable{
    private int number = 1;

    @Override
    public void run() {

        while(true){
            synchronized (this) {

                notifyAll();
                if(number <= 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    try {
                        ///使得调用如下wait（）方法的线程进入阻塞模式
                        wait();//this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
