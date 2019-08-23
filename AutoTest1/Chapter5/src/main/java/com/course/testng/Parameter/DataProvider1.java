package com.course.testng.Parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProvider1 {
    @Test(dataProvider = "data")
    public void test(String name,int age)
    {
        System.out.println("name:   "+name+"  age:::   "+age);
    }
    @DataProvider(name="data")
    public Object[][] a(){
        Object[][] m=new Object[][]{
                {"hhh",18},
                {"mmm",20}
        };
        return m;
    }

    @Test(dataProvider = "method1")
    public void test1(String name,int age)
    {
        System.out.println("test1"+"name:   "+name+"  age:::   "+age);
    }
    @Test(dataProvider = "method1")
    public void test2(String name,int age)
    {
        System.out.println("test1"+"name:   "+name+"  age:::   "+age);
    }
    @DataProvider(name="method1")
    public Object[][] b(Method method){
        Object[][] m =null;
        if(method.getName().equals("test1"))
        {
           m=new Object[][]{
                    {"hhh2",18},
                    {"mmm2222222222",20}
            };

        }

        if(method.getName().equals("test2"))
        {
           m=new Object[][]{
                    {"111hhh2",13},
                    {"12222mmm2222222222",20}
            };

        }

        return m;
    }



}
