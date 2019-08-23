package com.course.testng;
import org.testng.Assert;
import org.testng.annotations.*;
/**
 * Created by hp on 2019/8/5.
 */
public class BasicAnnotation {
    //最基本的注解，用来表示测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }
    @Test
    public void testcase2(){
        System.out.println("这是测试用例2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("测试方法之前运行的");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是测试方法之后运行的");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在类运行之前运行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("这是在类运行之后运行的方法");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("测试套件之前运行");
    }
    @AfterSuite
    public void afterSuite()
    {System.out.println("测试套件之后运行");}

}
