package com.atguigu.exer;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        Date date1 = new Date(2020-1900,9-1,8);//Fri Oct 08 00:00:00 CST 3920
        System.out.println(date1);



    }
    @Test
    public void test1(){
        //now():获取当前的日期、时间、日时同
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        //of():設置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020,10,2,13,23,43);
        System.out.println(localDateTime1);
        //get
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        //不可变性
        //withXxx()
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);
    }
    @Test
    public void test2(){
        //获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2020-07-27T11:40:54.110107Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970年1月1日0分秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //// ofepochmill():通过给定的毫秒数，获取 instant实例
        Instant instant1 = Instant.ofEpochMilli(1595850434501L);
        System.out.println(instant1);
    }


    /*
    * DatetimeFormatter：格式化或解析日、时同
    * 类似于SimpleDateFormat
    * */
    @Test
    public void test3(){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        //格式化：日期->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //解析： 字符串->日期
        TemporalAccessor parse = formatter.parse("2020-07-27T20:01:05.5389402");
        System.out.println(parse);

    }
}
