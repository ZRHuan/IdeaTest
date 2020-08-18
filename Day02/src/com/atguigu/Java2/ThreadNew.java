package com.atguigu.Java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现 Callable接口  JDK5.0新增
 *
 *如何理解实现 Callable接口的方式创建多线程比实现 Runnable接口创建多线程方式强大？
 * 1.call（）可纵有返回值的
 * 2.call（）可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型的
 *
 * @author zhangruhuan
 * @create 2020-06-06-21:58
 */
//1.创建一个实现 Callable的实现类
class NumThread implements Callable{
//    2.实现call方法，将此线程需要执行的操作声明在call（）中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 1; i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建 Callable接口实现类的对象
        NumThread numThread = new NumThread();
//        4.将此 Callable接口实现类的对象作为传递到 FutureTask构造器中，创建 FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
//        5.将 FutureTas的对象作为参数传递到Thr0类的构造器中，创建 Thread对象，并sta+（）
        new Thread(futureTask).start();
        try {
            //获取Callable中call方法的返回值
            //get（）返回值即为 futureTask构造器参数 Callable实现类重写的caLL（）的返回值
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
