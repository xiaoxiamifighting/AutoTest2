package com.course.cookies;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;
    @BeforeTest
    public void beforeTEst(){
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url = bundle.getString("test.url");
    }
    // 返回cookies信息的
    @Test
    public void TestGetCookies() throws IOException {
        String uri = bundle.getString("uri");
        String baseUrl = this.url + uri;
        System.out.println(baseUrl);
        HttpGet get = new HttpGet(baseUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(get);

        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        //获取cookies信息
        this.cookieStore = client.getCookieStore();
        List<Cookie> cookieList = this.cookieStore.getCookies();
        for (Cookie c : cookieList) {
            String name = c.getName();
            String value = c.getValue();
            System.out.println(name + "value:   " + value);
        }
    }
    @Test(dependsOnMethods={"TestGetCookies"})
    public void TestPostWithCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        //拼接最终的测试地址
        String testUrl = this.url+uri;
        System.out.println(testUrl);
        //声明一个client对象，用来进行方法的之心
        DefaultHttpClient client = new DefaultHttpClient();

        //声明一个方法，就是一个post方法
        HttpPost post = new HttpPost(testUrl);
        System.out.println("testurl2:"+testUrl);
        //携带参数，添加参数
        JSONObject param = new JSONObject();

        param.put("name", "xiaoxia");
        param.put("age", "18");

        //设置请求头信息
        post.setHeader("content-type","application/json");
        //将参数信息添加方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.cookieStore);
        //执行post方法，获取响应结果
        HttpResponse response=client.execute(post);
        //处理结果，就是判断返回的结果是否符合预期
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("result====================="+result);
        //将返回的响应结果字符串转化成json对象
        JSONObject resultjson =new JSONObject(result);
        //获取到结果值
        String success1 = (String) resultjson.get("xiaoxia");
        String status = resultjson.getString("status");
        //具体判断返回的结果值
        Assert.assertEquals("success",success1);
        Assert.assertEquals("1",status);



    }

}
