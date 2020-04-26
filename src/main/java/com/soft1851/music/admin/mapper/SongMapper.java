package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.entity.Song;
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
public interface SongMapper extends BaseMapper<Song> {

    /**
     * 通过歌单id查询歌曲列表
     * @param songListId
     * @return
     */
    @Select("SELECT * FROM song WHERE song_id  IN (SELECT song_id FROM song_list_music WHERE song_list_id = #{songListId})")
    List<Song> getSongsBySongListId(String songListId);
}
