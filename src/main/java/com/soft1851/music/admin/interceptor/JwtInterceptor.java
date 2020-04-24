package com.soft1851.music.admin.interceptor;

import com.alibaba.fastjson.JSONArray;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.entity.SysRole;
import com.soft1851.music.admin.exception.CustomException;
import com.soft1851.music.admin.service.SysRoleService;
import com.soft1851.music.admin.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 前置处理，拦截请求
     *
     * @param request
     * @param response
     * @param handler
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        //认证
        if (token == null) {
            log.info("### 用户未登录，请先登录 ###");
            //通过自定义异常抛出未登录的信息，由全局统一处理
            throw new CustomException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
        } else {
            //已经登录
            log.info("## token= {}", token);
            //从token中解析出roles字符串
            String roles = JwtTokenUtil.getRoles(token);
            log.info("## roles= {}", roles);
            //反序列化成List
            List<SysRole> roleList = JSONArray.parseArray(roles, SysRole.class);
            //从request中取得客户端传输的roleId
//            String param = request.getPathInfo().trim();
//            log.info("## param= {}", param);
//            log.info("## path= {}", request.getRequestURI());
//            String roleId = param.substring(param.indexOf("/") + 1);
            String roleId = request.getParameter("roleId");
            log.info("## roleId= {}", roleId);
            // 到roles中查找比对，此部分代码在SysRoleService
            boolean flag = sysRoleService.checkRole(roleList, Integer.parseInt((roleId)));
            log.info("## flag= {}", flag);
            //在token中解析出的roles中含有请求参数的role值,放行到controller中获取数据
            if (flag) {
                return true;
            } else {
                log.info("### 用户权限不足 ###");
                //通过自定义异常抛出权限不足的信息，由全局统一处理
                throw new CustomException("用户权限不足", ResultCode.PERMISSION_NO_ACCESS);
            }
        }
    }
}
