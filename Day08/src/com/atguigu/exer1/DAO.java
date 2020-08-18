package com.atguigu.exer1;

import java.util.*;

/**
 * @author zhangruhuan
 * @create 2020-08-07 20:13
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
//        Collection<T> values = map.values();
//        return (List<T>) values

        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t : values) {
            list.add(t);
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
