package com.atguigu.exer;

import org.junit.Test;

import java.util.Calendar;

public class DateTimeTest {
    @Test
    ////get()
    public void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
    ////set()
    }

}
