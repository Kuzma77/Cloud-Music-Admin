package com.soft1851.music.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.dto.ResetPasswordDto;
import com.soft1851.music.admin.service.RedisService;
import com.soft1851.music.admin.service.SmsService;
import com.soft1851.music.admin.util.PhoneCodeUtil;
import com.soft1851.music.admin.util.Salt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/**
 * @author wl_sun
 * @description TODO
 * @Data 2020/5/3
 */
@Service
@Slf4j
public class SmsServiceImpl implements SmsService {
    @Resource
    private RedisService redisService;
    @Override
    public ResponseResult sendSms(ResetPasswordDto signDto) {
        String mobile = signDto.getMobile();
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou",
                "LTAI4G3RbEnYyXpd2ez6jbo4",
                "6vVUWNdOhUunRQCLyrjszgKwVZMjkv");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "云音乐");
        request.putQueryParameter("TemplateCode", "SMS_189620953");
        String verifyCode = PhoneCodeUtil.getVerifyCode();
        request.putQueryParameter("TemplateParam", "{\"code\":" + verifyCode + "}");
        CommonResponse response;
        try {
            response = client.getCommonResponse(request);
        } catch (ClientException e) {
            log.error("短信发送异常");
            return ResponseResult.failure(ResultCode.SMS_ERROR);
        }
        //resData样例：{"Message":"OK","RequestId":"0F3A84A6-55CA-4984-962D-F6F54281303E","BizId":"300504175696737408^0","Code":"OK"}
        String resData = response.getData();
        //将返回的JSON字符串转成JSON对象
        JSONObject jsonObject = JSONObject.parseObject(resData);
        if ("OK".equals(jsonObject.get("Code"))) {
            System.out.println(verifyCode);
            //存入redis，1分钟有效
            redisService.set(mobile, verifyCode, 2L);
            return ResponseResult.success(verifyCode);
        } else {
            return ResponseResult.failure(ResultCode.SMS_ERROR);
        }
    }
    @Override
    public ResponseResult checkSms(ResetPasswordDto signDto) {
        String mobile = signDto.getMobile();
        String sms = signDto.getSms();
        System.out.println(signDto);
        String correctSms = redisService.getValue(mobile,String.class);
        System.out.println(correctSms);
        if (correctSms != null) {
            //将客户端传来的短信验证码和redis取出的短信验证码比对
            if (correctSms.equals(sms)) {
                return ResponseResult.success();
            } else {
                //验证码错误
                return ResponseResult.failure(ResultCode.USER_VERIFY_CODE_ERROR);
            }
        }
        //验证码失效
        return ResponseResult.failure(ResultCode.USER_CODE_TIMEOUT);
    }
}
