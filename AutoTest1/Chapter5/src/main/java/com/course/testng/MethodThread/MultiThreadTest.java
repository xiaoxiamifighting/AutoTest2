package com.course.testng.MethodThread;

import org.testng.annotations.Test;

public class MultiThreadTest {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test1(){
        System.out.println(Thread.currentThread().getId());
    }
}
