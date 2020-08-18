package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangruhuan
 * @create 2020-08-05 10:30
 */
public class Order<T> {

    String orderName;
    int orderId;
    T orderT;

    public Order() {
    }

    ;

    public Order(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderT = orderT;
    }

    public <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

}
