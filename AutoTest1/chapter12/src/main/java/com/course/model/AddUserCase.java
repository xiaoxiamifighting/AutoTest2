package com.course.model;

import lombok.Data;

/**
 * Created by hp on 2019/1/17.
 */

/**
 * `id` int(11) NOT NULL,
 `userName` varchar(50) DEFAULT NULL COMMENT '用户名',
 `password` int(11) DEFAULT NULL COMMENT '密码',
 `sex` int(11) DEFAULT NULL COMMENT '性别，0代表男，1代表女',
 `age` int(11) DEFAULT NULL COMMENT '年龄',
 `permission` int(11) DEFAULT NULL COMMENT '权限，0代表管理员，1代表普通用户',
 `isDelete` int(11) DEFAULT NULL COMMENT '是否被删除掉，0未删除，1已经删除',
 `expected` tinyint(1) DEFAULT NULL COMMENT '期望结果，true带有接口之后返回的字段',
 *
 *
 *
 *
 * */
@Data
public class AddUserCase {
    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
}
