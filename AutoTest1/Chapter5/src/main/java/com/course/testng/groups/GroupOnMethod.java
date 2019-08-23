package com.course.testng.groups;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @Test(groups="server")
    public void test1(){
        System.out.println("这个是服务端测试1");
    }
    @Test(groups="server")
    public void test2(){
        System.out.println("这个是服务端测试222");
    }
    @Test(groups="client")
    public void test3(){
        System.out.println("这个是客户端测试3");
    }
    @Test(groups="client")
    public void test4(){
        System.out.println("这个是客户端测试444");
    }
    @BeforeGroups("server")
    public void beforeOnGroupsServer(){
        System.out.println("这是服务端之前运行的");
    }
    @AfterGroups("server")
    public void afterOnGroupsServer(){
        System.out.println("这是服务端之hou运行的");

    }

    @BeforeGroups("client")
    public void beforeOnGroupsClient(){
        System.out.println("这是服务端之前运行的");

    }
    @AfterGroups("client")
    public void afterOnGroupsClient(){
        System.out.println("这是服务端之hou运行的");

    }


}
