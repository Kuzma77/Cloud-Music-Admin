package com.soft1851.music.admin.annotation;

import java.lang.annotation.*;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    //调用的接口名称
    String name() default  " ";
    //该日志是否持久存储
    boolean isSaved() default  false;
}
