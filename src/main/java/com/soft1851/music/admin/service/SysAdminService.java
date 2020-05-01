package com.soft1851.music.admin.service;

import com.soft1851.music.admin.dto.AdminDto;
import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
public interface SysAdminService extends IService<SysAdmin> {
    /**
     * 登录
     *
     * @param loginDto
     * @return boolean
     */
    Map<String,Object> login(LoginDto loginDto);

    /**
     * 根据account查询Admin
     * @param account
     * @return
     */
    SysAdmin getAdmin(String account);

    /**
     * 修改个人信息
     * @param adminDto
     */
    void updateSysAdmin(AdminDto adminDto);

    /**
     *
     * 修改密码
     * @param password
     * @param id
     */
    void updatePassword(String password,String id);

    /**
     * 为指定的管理员生成token
     * @param adminId
     * @param roles
     * @param secrect
     * @param expiresAt
     * @return String
     */
    String getToken(final String adminId, final String roles, final String secrect, Date expiresAt);
}
