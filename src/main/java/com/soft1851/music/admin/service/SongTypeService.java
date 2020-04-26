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

    /**
     * 新增一个类型type(只给名字)
     * @param typeName
     * @return
     */
    void addType(String typeName);

    /**
     * 删除类型，将delete_flag改为1
     * @param typeName
     * @return
     */
    void deleteType(String typeName);

}
