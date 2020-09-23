package com.xxxx.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class ValuationID {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static int get_id() {
        return atomicInteger.incrementAndGet();
    }
}
