package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());
        System.out.println(coll.size());

        Collection coll1 = new ArrayList();
        coll1.add("CC");
        coll1.add(123);
        coll.addAll(coll1);
        System.out.println(coll.size());
    }
}
