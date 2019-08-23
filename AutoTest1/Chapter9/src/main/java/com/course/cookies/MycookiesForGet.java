package com.course.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MycookiesForGet {
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
        String baseUrl = this.url+uri;
        System.out.println(baseUrl);
        HttpGet get = new HttpGet(baseUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(get);
        CookieStore cc = client.getCookieStore();
        List<Cookie> cookieList1 = cc.getCookies();
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        this.cookieStore = client.getCookieStore();
        List<Cookie> cookieList = this.cookieStore.getCookies();
        for(Cookie c:cookieList)
        {
            String name = c.getName();
            String value = c.getValue();
            System.out.println(name + "value:   "+value);
        }

    }

    //这个是携带cookies信息的
    @Test(dependsOnMethods = {"TestGetCookies"})
    public void withCookies() throws IOException {
        String uri = bundle.getString("cookies.uri");
        String baseUrl = this.url+uri;
        HttpGet get = new HttpGet(baseUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(get);
        int code = response.getStatusLine().getStatusCode();
        if(code == 200)
        {
            String result= EntityUtils.toString(response.getEntity());
            System.out.println(result);        }
        System.out.println(code);

    }
}
