package com.soft1851.music.admin.service;

import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.ResetPasswordDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SmsServiceTest {
@Resource
private SmsService smsService;
    @Test
    void sendSms() {
        ResetPasswordDto rpDto = ResetPasswordDto.builder()
                .mobile("18851860805")
                .build();
        ResponseResult result = smsService.sendSms(rpDto);
        assertEquals(1, result.getCode());
        System.out.println(result);

    }

    @Test
    void checkSms() {
        ResetPasswordDto rpDto = ResetPasswordDto.builder()
                .mobile("18805167526")
                .sms("042499")
                .build();
        ResponseResult result = smsService.checkSms(rpDto);
        if (result.getCode() == 1) {
            System.out.println("验证通过");
        } else {
            System.out.println(result.getMsg());
        }
    }
}