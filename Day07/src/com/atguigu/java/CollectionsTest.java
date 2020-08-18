package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangruhuan
 * @create 2020-08-05 9:02
 */
public class CollectionsTest {
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
//        System.out.println(list);
//        Collections.reverse(list);
//        System.out.println(list);
//        Collections.shuffle(list);
//        System.out.println(list);
        int frequency = Collections.frequency(list, 765);
        System.out.println(frequency);

    }

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest,list);
        System.out.println(dest);


        List list1 = Collections.synchronizedList(list);
    }
}
