package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups="stu")
public class GroupsOnClass1 {
    public  void Stud1()
    {
        System.out.println("class1__stud111111");
    }

    public  void Stud2()
    {
        System.out.println("class1__stud222222222222");
    }
}
