package com.course.model;

import lombok.Data;

/**
 * Created by hp on 2019/1/17.
 */
@Data
public class UpdateUserInfoCase {
    private  int id;
    private int userId;
    private String userName;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
}
