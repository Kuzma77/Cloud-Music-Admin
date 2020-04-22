package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;
import com.soft1851.music.admin.service.SysAdminService;
import com.soft1851.music.admin.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/sysAdmin")
@Slf4j
public class SysAdminController {
    @Resource
    private SysAdminService sysAdminService;
    /**
     * 登录
     *
     * @return String
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginDto loginDto) {
        log.info(loginDto.toString());
        boolean login = sysAdminService.login(loginDto);
        if (login) {
            SysAdmin admin = sysAdminService.getAdmin(loginDto.getName());
            String token = JwtTokenUtil.getToken(admin.getId(), "admin", new Date(System.currentTimeMillis() + 60L * 1000L));
            return ResponseResult.success(token);
        } else {
            return ResponseResult.failure(ResultCode.USER_SIGN_IN_FAIL);
        }
    }

    @GetMapping(value = "/{adminName}")
    public SysAdmin getRoleByName(@PathVariable String adminName){
        return sysAdminService.getAdmin(adminName);
    }
}

