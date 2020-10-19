package com.xxxx.test;

import com.xxxx.entity.Theme;

public class NullTest {
    Double t;
    Theme theme;

    public Theme getTheme() {
        return theme;
    }

    public Double getT() {
        return t;
    }

    public static void main(String[] args) {
        String s = null;
        String e = "e";

        // equals() test
        // the object in equals() can be null
        System.out.println(e.equals(s));
        // If invoking object s is null, method invocation 'equals' will produce 'NullPointerException'
        //System.out.println(s.equals(e));
        System.out.println(s==null ? e==null : s.equals(e));

        // forloop test
        Double[] dd = {};
        for (Double d : dd) {
            System.out.println("count");
        }

        // && test
        boolean b = s==null ? e==null : s.equals(e) && e==null ? s==null : e.equals(s);
        System.out.println(b);

        // getter test
        NullTest nt = new NullTest();
        System.out.println(nt.getT());
        System.out.println(nt.getTheme());

        // instance test
        System.out.println(null instanceof Double);
    }
}
