package com.course.cases;
import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.Logincase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by hp on 2019/1/18.
 */
public class LoginTest {
    @BeforeTest(groups="loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest() {
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);

        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);

        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);

        TestConfig.updateUserInforUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }
    @Test(groups="loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException, InterruptedException {
        System.out.println("hhhhhahahha");
        SqlSession session = DatabaseUtil.getSqlSession();//这个是包装了一下，session
        System.out.println("进来了=============");
        Logincase loginCase = session.selectOne("loginCase",1);//loginCase是sql中的id
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
        //上面只是取了的数据，没有进行验证，下面是进行发送请求，然后进行验证
        //发送请求
        Thread.sleep(300);
       String result = getResult(loginCase);
       //验证结果
       Assert.assertEquals(loginCase.getExpected(),result);

    }


    @Test(groups="loginFalse",description="用户登录失败的接口测试")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        Logincase loginCase = session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
        //发送请求
        String result = getResult(loginCase);
        //验证结果
        Assert.assertEquals(loginCase.getExpected(),result);


    }
    private String getResult(Logincase loginCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }
}
