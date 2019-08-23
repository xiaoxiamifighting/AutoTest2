package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.model.User1;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class GetUserInfoListTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户信息")
    public void getUserInfoListInfo() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserListCase getUserInfoListCase = session.selectOne("getUserInfoListCase",1);
        System.out.println(getUserInfoListCase);
        System.out.printf(TestConfig.getUserListUrl);
        //发送请求获取的的结果
        JSONArray resultJson = getJsonResult(getUserInfoListCase);
        Thread.sleep(300);

        //验证结果
        List<User1> userList = session.selectList("getUserList",getUserInfoListCase);
        for(User1 u:userList)
        {
            System.out.println("获取的user:"+u.toString());

        }
        JSONArray userListJson = new JSONArray(userList);
        Assert.assertEquals(userListJson.length(),resultJson.length());
        for(int i =0;i<resultJson.length();i++)
        {
            JSONObject expect =(JSONObject)resultJson.get(i);
            JSONObject actual =(JSONObject)userListJson.get(i);
            Assert.assertEquals(expect.toString(),actual.toString());
        }

    }

    private JSONArray getJsonResult(GetUserListCase getUserInfoListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userName",getUserInfoListCase.getUserName());
        param.put("age",getUserInfoListCase.getAge());
        param.put("sex",getUserInfoListCase.getSex());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONArray jsonArray = new JSONArray(result);
        return jsonArray;
    }


}
