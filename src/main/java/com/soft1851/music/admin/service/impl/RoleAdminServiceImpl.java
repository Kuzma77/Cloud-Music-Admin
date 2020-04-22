package com.soft1851.music.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft1851.music.admin.entity.RoleAdmin;
import com.soft1851.music.admin.entity.RoleMenu;
import com.soft1851.music.admin.mapper.RoleAdminMapper;
import com.soft1851.music.admin.mapper.RoleMenuMapper;
import com.soft1851.music.admin.service.RoleAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
@Service
public class RoleAdminServiceImpl extends ServiceImpl<RoleAdminMapper, RoleAdmin> implements RoleAdminService {
@Resource
private RoleAdminMapper roleAdminMapper;
    @Override
    public List<RoleAdmin> getRoleByAdminId(String adminId) {
        QueryWrapper<RoleAdmin>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_id",adminId);
        List<RoleAdmin> roleAdmins = roleAdminMapper.selectList(queryWrapper);
        return roleAdmins;
    }
}
