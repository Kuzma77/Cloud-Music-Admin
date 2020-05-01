package com.soft1851.music.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull(message = "account 不能为空")
    private String account;
    @NotNull(message = "password 不能为空")
    private String password;
    @NotNull(message = "verifyCode 不能为空")
    private String verifyCode;
}
