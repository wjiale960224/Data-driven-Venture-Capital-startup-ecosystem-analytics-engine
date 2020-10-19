package com.xxxx.test;

import com.xxxx.entity.DealID;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-09-02");
        System.out.println(date);

        System.out.println(LocalDate.parse("2019-09-02"));
        System.out.println(LocalDate.now().toString());

    }
}
