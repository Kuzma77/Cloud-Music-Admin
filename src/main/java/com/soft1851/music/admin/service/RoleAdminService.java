package com.soft1851.music.admin.service;

import com.soft1851.music.admin.entity.RoleAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1851.music.admin.entity.SysRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
public interface RoleAdminService extends IService<RoleAdmin> {
    /**
     *
     * 根据id查询角色id
     * @param adminId
     * @return List<RoleAdmin>
     */
    List<RoleAdmin>  getRoleByAdminId(String adminId);
}
