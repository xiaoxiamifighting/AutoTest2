package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value="/",description = "这是我的 post方法")
@RequestMapping("/v1")
public class MyPostMethod {
    //这个变量用来存放我们的cookies信息的
    private static Cookie cookie;
    //用户登录成功获取到cookies，然后再访问其他接口获取到列表
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ApiOperation(value="这是cookies中的post",httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam(value = "username",required=true) String userName,
                      @RequestParam(value="passWord",required = true) String passWord){
        //@RequestParam(value="passWord",required = true) 中的value是前端进行传的，required=true是必须要传的
        //把cookies加入到里面就可以进行访问了
        if(userName.equals("张三")&& passWord.equals("123456"))
        {
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功";
        }
        return "用户名或者密码错误";

    }
    @RequestMapping(value="/getUserList",method=RequestMethod.POST)
    @ApiOperation(value="获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User user) {
        //获取cookies
        Cookie[] cookie = request.getCookies();
        User u =new User();
        for (Cookie c : cookie) {
            if (c.getName().equals("login") && c.getValue().equals("true")
                    && user.getUserName().equals("张三") && user.getPassWord().equals("123456")) {
                u.setUserName("hh");
                u.setAge(18);
                u.setPassWord("0");
                u.setSex(true);
                return u.toString();

            }

        }
        return "参数不合法";
    }
}
