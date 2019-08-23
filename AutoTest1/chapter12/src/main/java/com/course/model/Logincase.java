package com.course.model;

import lombok.Data;

/**
 * Created by hp on 2019/1/17.
 */
@Data
public class Logincase {
    /*
    * `id` int(11) NOT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `password` int(11) DEFAULT NULL COMMENT '密码',
  `expected` tinyint(1) DEFAULT NULL COMMENT 'TRUE|false',
    *
    * */

    private int id;
    private String userName;
    private String password;
    private String expected;
}
