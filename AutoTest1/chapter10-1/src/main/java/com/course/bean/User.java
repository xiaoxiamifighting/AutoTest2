package com.course.bean;

import lombok.Data;

@Data   //引入lombok
public class User {
    private String userName;
    private String passWord;
    private int age;
    private boolean sex;
}
