package com.xxxx.entity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zihang
 * @date 2020/9/14
 */

public class CompanyID {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static Integer get_id() {
        return atomicInteger.incrementAndGet();
    }
}
