package com.course.model;

import lombok.Data;

/**
 * Created by hp on 2019/1/17.
 */
@Data
public class User1 {

    /*

    *
     *`id` int(11) NOT NULL,
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` int(11) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` int(11) DEFAULT NULL COMMENT '性别，0代表男，1代表女',
  `permission` int(11) DEFAULT NULL COMMENT '权限，0代表管理员，1代表普通用户',
  `isDelete` int(11)
      *
      * */
    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
    @Override
    public String toString(){
        return ("{"+"id:"+id+","+
                "userName:"+userName+","+
                "password:"+password+","+
                "age:"+age+","+
                "sex:"+sex+","+
                "permission:"+permission+","+
                "isDelete:"+isDelete+"}"
        );
    }
}
