package com.soft1851.music.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wl_sun
 * @description TODO
 * @Data 2020/5/3
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordDto {
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 短信验证码
     */
    private String sms;
}
