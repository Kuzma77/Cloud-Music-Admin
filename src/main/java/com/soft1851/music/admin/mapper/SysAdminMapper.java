package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.dto.AdminDto;
import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
public interface SysAdminMapper extends BaseMapper<SysAdmin> {
    /**
     * 根据account查询管理员信息，包含其所有角色
     * @param account
     * @return
     */
    SysAdmin selectByAccount(@Param("account") String account);

    /**
     * 根据account查询admin基础信息，用于个人信息，登录等
     * 避开其中的List<SysRole>属性，因为它没有映射字段
     * @param account
     * @return
     */
    @Select("SELECT * FROM sys_admin WHERE account = #{account}")
    SysAdmin getSysAdminByAccount(@Param("account") String account);


    /**
     *
     * 修改个人信息
     * @param adminDto
     */
    void updateSysAdmin(AdminDto adminDto);

    /**
     * 修改密码
     * @param password
     * @param id
     */
    @Update("UPDATE sys_admin SET password=#{password} WHERE id=#{id}")
    void updatePassword(String password,String id);

    /**
     * 查询所有用户名
     * @return
     */
    @Select("SELECT sys_admin.name FROM sys_admin")
    List<String> selectAllName();
}
