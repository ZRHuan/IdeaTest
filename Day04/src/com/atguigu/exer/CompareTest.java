package com.atguigu.exer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*


 */
public class CompareTest {
    @Test
    public void test2(){
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("HuaWeiMouse",65);
        arr[5] = new Goods("HuaWeiMouse",224);
        arr[4] = new Goods("microMouse",43);
        Arrays.sort(arr,
                new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        if(o1 instanceof Goods && o2 instanceof Goods){
                            Goods g1 = (Goods)o1;
                            Goods g2 = (Goods)o2;
                            if(g1.getName().equals(g2.getName())){
                                return -Double.compare(g1.getPrice(),g2.getPrice());
                            }else{
                                return g1.getName().compareTo(g2.getName());
                            }
                        }
//                        return 0;
                        throw new RuntimeException();
                    }
                });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test1(){
        String[] arr = new String[]{"aa","nn","qq"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test3(){
        String[] arr = new String[]{"aa","nn","qq","hh","jj"};
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException();
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
