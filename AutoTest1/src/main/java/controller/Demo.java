package com.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController//这是springboot扫描的类
@Api(value="/v1",description="这是我的第一个版本的demo")//value是和下面requestmapping一直的
@RequestMapping("/v1")
public class Demo {
    //首先获取一个执行sql语句的对象
    @Autowired//启动即加载
    private SqlSessionTemplate template;
    @RequestMapping(value="/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value="可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");//这个是从mysql.xml中的id 取出的
    }
}
