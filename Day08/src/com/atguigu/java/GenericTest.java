package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author zhangruhuan
 * @create 2020-08-05 9:44
 */
public class GenericTest {
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
//        list.add("Tom");
        for (Object score : list) {
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
//        list.add("Tom");
//        for (int score : list) {
//            int StuScore = score;
//
//        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int next = iterator.next();
            System.out.println(next);
        }
    }
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "---------------"  +  value);
        }
    }
}
