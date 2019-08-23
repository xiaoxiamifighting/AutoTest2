package com.course.testng;

import org.testng.annotations.Test;

public class IgonoreTest {
    @Test
    public void Test1(){
        System.out.println("test1");
    }
    @Test(enabled=false)
    public void Test2(){
        System.out.println("test1");
    }
    @Test(enabled=true)
    public void Test3(){
        System.out.println("test1");
    }
}
