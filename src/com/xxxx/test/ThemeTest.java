package com.xxxx.test;

import com.xxxx.entity.Theme;

/**
 * @author Fei
 * @date 2020/10/7 12:58
 */
public class ThemeTest {
    public static void main(String[] args) {
        Theme t1 = Theme.Exponential_Machines;
        Theme t2 = Theme.Exponential_Machines;

        Double d1 = 1.0;
        Double d2 = 1.0;
        System.out.println(d1.equals(d2));
        System.out.println(t1==t2);
    }
}
