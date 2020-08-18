package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(123);
        coll.add(456);
        coll.add(false);
//        Person p = new Person("Jerry",20);
//        coll.add(p);

        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry", 20)));
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        Collection coll1 = new ArrayList();
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.remove(456);
        coll1=coll;
        coll.retainAll(coll1);
        System.out.println(coll);
        System.out.println(coll.hashCode());
    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(123);
        coll.add(456);
        coll.add(false);
        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
