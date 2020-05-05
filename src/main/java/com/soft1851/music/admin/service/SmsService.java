package com.soft1851.music.admin.service;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.ResetPasswordDto;

/**
 * @author wl_sun
 * @description TODO
 * @Data 2020/5/3
 */
public interface SmsService {
    /**
     * 获取短信验证
     * @param rpDto
     * @return ResponseResult
     */
    ResponseResult sendSms(ResetPasswordDto rpDto);
    /**
     * 验证短信是否正确（signDto中有手机号和验证码两部分内容）
     * @param rpDto
     * @return ResponseResult
     */
    ResponseResult checkSms(ResetPasswordDto rpDto);
}
