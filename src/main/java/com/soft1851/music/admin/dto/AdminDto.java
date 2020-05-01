package com.soft1851.music.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author wl_sun
 * @description TODO
 * @Data 2020/5/1
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

    private String id;

    private String account;

    private String name;

    private String avatar;

    private LocalDateTime updateTime;

    private Integer status;
}
