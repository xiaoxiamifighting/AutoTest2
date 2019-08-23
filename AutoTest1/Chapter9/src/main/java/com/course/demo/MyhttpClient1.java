package com.course.demo;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyhttpClient1 {
    @Test
    public void test() throws IOException {
        String result;
        HttpGet httpget = new HttpGet("http://www.baidu.com");
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(httpget);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);



    }
}
