package com.soft1851.music.admin.service;

import com.soft1851.music.admin.entity.SongType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
public interface SongTypeService extends IService<SongType> {

    /**
     *
     * 获取所有歌曲类型名及其所含歌曲
     * @return List<Map<String,Object>>
     */
    List<Map<String,Object>> getAllType();

}
