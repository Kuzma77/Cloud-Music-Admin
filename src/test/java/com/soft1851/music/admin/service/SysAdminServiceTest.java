package com.soft1851.music.admin.service;

import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.util.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysAdminServiceTest {
    @Resource
    private SysAdminService sysAdminService;

    @Test
    void login() {
//        LoginDto loginDto = LoginDto.builder().name("music").password("123456").build();
//        assertTrue(sysAdminService.login(loginDto));
    }

    @Test
    void getAdmin() {
        System.out.println(sysAdminService.getAdmin("soft1851"));
    }

}