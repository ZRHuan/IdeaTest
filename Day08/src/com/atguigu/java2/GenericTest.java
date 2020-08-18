package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangruhuan
 * @create 2020-08-05 21:51
 */
public class GenericTest {

    /*
    虽然类A是类B的父类，但是G<A> G<B>二考不具父类关系，二者是并列关系
    * */
    @Test
    public void test(){
        Object obj = null;
        String str = null;
        obj = str;
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
        List<Object> list1 = null;
        List<String> list2 = null;
//        list1 = list2;

    }
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
//        不能向List<?>内部添加任何数据
//        只能添加null
//        list.add("DD");
        Object o = list.get(0);
        System.out.println(o);
    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;
        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;
        list2 = list5;
        list2 = list4;
//        list2 = list3;

        list1 = list3;
        Person p = list1.get(0);
//        list1.add()
    }
}
