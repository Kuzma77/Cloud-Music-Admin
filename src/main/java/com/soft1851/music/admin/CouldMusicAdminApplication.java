package com.soft1851.music.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//注册过滤器注解
@ServletComponentScan
@MapperScan("com.soft1851.music.admin.mapper")
public class CouldMusicAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouldMusicAdminApplication.class, args);
    }

}
