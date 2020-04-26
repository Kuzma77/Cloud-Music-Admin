package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.entity.Song;
import com.soft1851.music.admin.entity.SongList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
public interface SongListMapper extends BaseMapper<SongList> {

    /**
     *
     * 查询所有歌单
     * @return
     */
    @Select("SELECT * FROM song_list")
    List<SongList> getAll();


    /**
     * 根据歌单id获取歌单详细信息
     * @param songListId
     * @return
     */
    @Select("SELECT * FROM song_list WHERE song_list_id = #{songListId}")
    SongList selectBySongListId(String songListId);

}
