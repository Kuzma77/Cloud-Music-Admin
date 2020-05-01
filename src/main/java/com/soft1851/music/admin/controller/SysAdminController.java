package com.soft1851.music.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.soft1851.music.admin.annotation.ControllerWebLog;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.dto.AdminDto;
import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;
import com.soft1851.music.admin.entity.SysRole;
import com.soft1851.music.admin.service.SysAdminService;
import com.soft1851.music.admin.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
@Validated
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
    @ControllerWebLog
    public Map login(@RequestBody @Valid LoginDto loginDto) {
        log.info(loginDto.toString());
        return sysAdminService.login(loginDto);
    }

    @GetMapping(value = "/{adminName}")
    @ControllerWebLog
    public SysAdmin getRoleByName(@Valid @PathVariable @Size(max = 10,message = "name长度超出范围") String adminName ){
        return sysAdminService.getAdmin(adminName);
    }

    @PostMapping(value = "/update")
    @ControllerWebLog
    public void updateAdminById(@RequestBody AdminDto adminDto){
        sysAdminService.updateSysAdmin(adminDto);
    }

    @PostMapping(value = "/updatePassword")
    @ControllerWebLog
    public void updatePassword(@Param("password") String password,@Param("id") String id){
        sysAdminService.updatePassword(password,id);
    }
}

