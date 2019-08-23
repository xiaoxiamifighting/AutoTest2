package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value="/v1" ,description="这是我的第一个版本的demo")
@RequestMapping("/v1")
public class Demo {
    //首先获取一个执行sql语句的对象
    @Autowired//启动即加载
    private  SqlSessionTemplate template;
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value="可以获取到用户数",httpMethod = "GET")
    public int getUserCount() {
        return  template.selectOne("getUserCount");//这个是从mysql中的id中去到的

    }
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    @ApiOperation(value="增加一个用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        return template.insert("addUser",user);


    }
    @RequestMapping(value="/updateUser",method=RequestMethod.POST)
    public int updateUser(@RequestBody User user)
    {
        return template.update("updateUser",user);
    }
    @RequestMapping(value="/deleteUser",method = RequestMethod.POST)
    public int deleteUser(@RequestParam int id)
    {
        return template.delete("deleteUser",id);
    }

}

