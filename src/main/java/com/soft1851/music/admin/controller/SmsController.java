package com.soft1851.music.admin.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.soft1851.music.admin.annotation.ControllerWebLog;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.ResetPasswordDto;
import com.soft1851.music.admin.service.RedisService;
import com.soft1851.music.admin.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wl_sun
 * @description TODO
 * @Data 2020/5/3
 */
@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {
    @Resource
    private SmsService smsService;
    @PostMapping("/send")
    @ControllerWebLog
    public ResponseResult sendSms(@RequestBody ResetPasswordDto rsDto){
        return smsService.sendSms(rsDto);
    }

    @PostMapping("/check")
    @ControllerWebLog
    public ResponseResult checkSms(@RequestBody ResetPasswordDto rsDto){
        return smsService.checkSms(rsDto);
    }
}
