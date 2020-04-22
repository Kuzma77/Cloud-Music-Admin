package com.soft1851.music.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft1851.music.admin.entity.RoleAdmin;
import com.soft1851.music.admin.mapper.RoleAdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RoleAdminServiceTest {
    @Resource
    private RoleAdminMapper roleAdminMapper;
    @Test
    void getRoleByAdminId() {
        QueryWrapper<RoleAdmin>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_id","DE35D7CC05AF96A21D7ADFC8651E6614");
        List<RoleAdmin> roleAdmins = roleAdminMapper.selectList(queryWrapper);
        roleAdmins.forEach(System.out::println);
    }
}