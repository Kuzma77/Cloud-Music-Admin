package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.annotation.ControllerWebLog;
import com.soft1851.music.admin.service.SysRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
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
@Validated
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @GetMapping()
    @ControllerWebLog
    public Map<String,Object> getRoleById(@Valid @Param("roleId") @Min(value = 1,message = "id必须大于0") int roleId) {
        return sysRoleService.selectRoleById(roleId);
    }
}
