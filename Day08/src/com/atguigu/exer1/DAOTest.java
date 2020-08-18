package com.atguigu.exer1;

import java.util.List;

/**
 * @author zhangruhuan
 * @create 2020-08-07 20:26
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<User>();
        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,20,"昆凌"));
        dao.save("1003",new User(1003,25,"蔡依林"));

        dao.update("1003",new User(1003,30,"方文山"));
        List<User> list = dao.list();
        System.out.println(list);
        list.forEach(System.out::println);
    }
}
