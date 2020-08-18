package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author zhangruhuan
 * @create 2020-08-03 17:16
 */
public class MpaTest {
    @Test
    public void test1() {
        HashMap map = new HashMap();
        map.put(null, null);
    }

//        map.put("AA",123);

    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        map.put("AA", 87);
        System.out.println(map);
        Map map1 =new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map1.putAll(map);
        System.out.println(map1);
        map1.remove("CC");
        System.out.println(map1);
        map1.clear();
        System.out.println(map1.size());
        System.out.println(map1);
    }
@Test
    public void test4(){
    Map map = new HashMap();
    map.put("AA",123);
    map.put("BB",56);
    map.put(45,123);
    System.out.println(map.isEmpty());
    System.out.println(map.get(45));
    System.out.println(map.containsKey(45));

}
@Test
    public void test5(){
    Map map =  new HashMap();
    map.put("AA",123);
    map.put("BB",56);
    map.put(45,123);
    Set set = map.keySet();
    Iterator iterator = set.iterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }
    System.out.println("********");
    Collection values = map.values();
    for (Object obj : values) {
        System.out.println(obj);

    }
    System.out.println("******");
    Set entrySet = map.entrySet();
    Iterator iterator1 = entrySet.iterator();
    while(iterator1.hasNext()){
        Object obj = iterator1.next();
//        System.out.println(iterator1.next());
        Map.Entry entry = (Map.Entry)obj;//强转
        System.out.println(entry.getKey() + "---------->>" + entry.getValue());
    }


//    方法二
    System.out.println();
    Set set1 = map.keySet();
    Iterator iterator2 = set1.iterator();

    while (iterator2.hasNext()){
        Object key = iterator2.next();
        Object value = map.get(key);
        System.out.println(key + "+++++" + value);
    }


}
}
