package com.soft1851.music.admin;

/**
 * @author wl_sun
 * @description TODO
 * @Data 2020/5/3
 */

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 短消息测试程序
 */
public class SMSTest {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G3RbEnYyXpd2ez6jbo4",  "6vVUWNdOhUunRQCLyrjszgKwVZMjkv");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "18805167526");
        request.putQueryParameter("SignName", "云音乐");
        request.putQueryParameter("TemplateCode", "SMS_189620953");
        request.putQueryParameter("TemplateParam", "{\"code\":\"888888\"}");   //发送的验证码
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}