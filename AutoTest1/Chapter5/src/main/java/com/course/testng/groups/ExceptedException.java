package com.course.testng.groups;

import org.testng.annotations.Test;

public class ExceptedException {
    /**
     * 什么时候会用到异常测试呢？？？
     * 在我们期望结果为某一个异常的时候，
     * 比如我们传入了某些不合法的参数，程序抛出了异常
     * 也就是我的预期结果就是这个异常
     */
    //这是一个测试结果会失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeEFailed(){
        System.out.println("这是一个失败的测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeSuccess(){
        System.out.println("这是一个失败chengg的测试");
        throw new RuntimeException();
    }
}
