package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.service.SysRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @GetMapping("/{roleId}")
    public Map<String,Object> getRoleById(@PathVariable int roleId) {
        return sysRoleService.selectRoleById(roleId);
    }
}
