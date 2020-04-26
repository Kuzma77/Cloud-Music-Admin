package com.soft1851.music.admin.service;

import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongList;
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
public interface SongListService extends IService<SongList> {

    /**
     *
     * 分页查询歌单
     * @param pageDto
     * @return
     */
    Map<String,Object> getByPage(PageDto pageDto);

    /**
     * 根据歌单id获取歌单详细信息，包括歌曲
     * @param songListId
     * @return
     */
    Map<String, Object> selectSongsBySongListId(String songListId);
}
