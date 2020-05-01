package com.soft1851.music.admin.config;

import com.soft1851.music.admin.interceptor.JwtInterceptor;
import com.soft1851.music.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @ClassName WebConfig
 * @Description 注册拦截器等Web配置
 * @Author wl_sun
 * @Date 2020/4/15
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;
    @Resource
    private JwtInterceptor jwtInterceptor;

    /**
     * 添加拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/sysAdmin/login").excludePathPatterns("/**").excludePathPatterns("/static/**");
        //registry.addInterceptor(jwtInterceptor).addPathPatterns("/sysRole").excludePathPatterns("**").excludePathPatterns("/static/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/sysAdmin/login");
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/sysAdmin/login","/captcha","/songType/all","/songType/add","/songType/delete","/songList/getByPage","/songList/all","/songList/getSongList","/resources/songs","/sysAdmin/update","/sysAdmin/updatePassword").excludePathPatterns("/static/**");
    }
}

