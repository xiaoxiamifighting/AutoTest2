package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by hp on 2019/1/18.
 *
 */
public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    /*
    * 帮助我们直接拼接url，测试的时候用工具类，就可以直接获取到了。直接输入一个
    * 枚举类型的接口类型，就可以获取到url
    *
    * */
    public static String getUrl(InterfaceName name)
    {
        String address=bundle.getString("test.url");
        String uri="";
        //最终的测试地址
        String testUrl;

        if(InterfaceName.LOGIN==name)
        {
            uri=bundle.getString("login.uri");
        }
        if(InterfaceName.ADDUSERINFO==name)
        {
            uri=bundle.getString("addUserInfo.uri");
        }
        if(InterfaceName.UPDATEUSERINFO==name)
        {
            uri=bundle.getString("updateUserInfo.uri");
        }
        if(InterfaceName.GETUSERLIST==name)
        {
            uri=bundle.getString("getUserList.uri");
        }
        if(InterfaceName.GETUSERINFO==name)
        {
            uri=bundle.getString("getUserInfo.uri");
        }
        testUrl = address+uri;

        return testUrl;
    }
}
