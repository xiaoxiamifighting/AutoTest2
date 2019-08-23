package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups="teach")
public class GroupOnClass3 {
    public void test1(){
        System.out.println("groupsOnClass3-----111");
    }

    public void test2(){
        System.out.println("groupsOnClass3-----222");
    }
}
