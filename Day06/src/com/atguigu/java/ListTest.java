package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author zhangruhuan
 * @create 2020-08-02 12:06
 */
public class ListTest {
 @Test
    public void test(){
     ArrayList list = new ArrayList();
     list.add(123);
     list.add(456);
     list.add("MM");
     list.add("HHHHH");
     list.add(456);
     System.out.println(list);
//     Arrays.asList(1,2,3,4,5);
//     list.addAll(list);
     System.out.println(list.lastIndexOf(456));
     list.set(1,"CC");
     System.out.println(list);

 }
}
