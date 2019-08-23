package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut=3000)
    public void test1()
    {
        System.out.println("hh");
    }
    @Test(timeOut=10)
    public void test2() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("hh");
    }
}
