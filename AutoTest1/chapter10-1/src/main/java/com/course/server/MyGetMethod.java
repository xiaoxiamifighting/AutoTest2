package com.course.server;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController//我就是你托管的程序
@Api(value = "/",description = "这是我全部的方法") //这是swagger
public class MyGetMethod {
    @RequestMapping(value="/getCookies",method= RequestMethod.GET)
    @ApiOperation(value="这是有cookies响应信息的",httpMethod = "GET")//这是swagger
    public String getCookies(HttpServletResponse response){
       // HttpServletRequest:装请求信息的
        //HttpServletResponse 装响应信息的
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return  "恭喜你获得cookies信息成功";
    }
    /**
     * 这是一个携带cookies信息才能访问的get请求
     * 必须要求客户端懈怠cookies信息
     */
    @RequestMapping(value="/get/with/cookies",method=RequestMethod.GET)
    @ApiOperation(value="这是一个携带cookies信息才能访问的get请求",httpMethod = "GET")//这是swagger
    public String getWithCookies(HttpServletRequest request)

    {
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies))
        {
            return "你必须携带cookie信息";

        }
        for(Cookie c:cookies)
        {
            if(c.getName().equals("login")&&c.getValue().equals("true"))
            {
                return "恭喜访问成功";
            }
        }
        return "你必须携带cookie信息";

    }
    /**
     * 开发一个需要携带参数才可以访问的get请求
     * 第一种访问方式url  ?key=value&key=value
     * 模拟一个获取商品列表的
     */
    @RequestMapping(value="/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value="第一种访问方式url  ?key=value&key=value",httpMethod = "GET")//这是swagger
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end)
    {
        Map<String,Integer> myList = new HashMap();
        myList.put("鞋子",400);
        myList.put("干脆面",1);
        myList.put("xiao环形哦",100);
        return myList;
    }
    /**
     * 第二种需要携带参数访问的请求
     * url ip:port/get/with/param/10/20
     * 其中10和20 是你要携带的数据，就是本方法中的start和end
     */
    @RequestMapping(value="/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value="第二种",httpMethod = "GET")
    public Map<String,Integer> getList1(@PathVariable Integer start,
                                       @PathVariable  Integer end)
    {
        Map<String,Integer> myList = new HashMap();
        myList.put("鞋子",400);
        myList.put("干脆面",1);
        myList.put("xiao环形哦",100);
        return myList;
    }

}
