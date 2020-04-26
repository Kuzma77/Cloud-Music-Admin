package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.entity.SongList;
import com.soft1851.music.admin.entity.SongType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
public interface SongTypeMapper extends BaseMapper<SongType> {

    /**
     * 通过类型名获取它的所有歌曲
     * @param type
     * @return
     */
    @Select("SELECT * FROM song_list WHERE type=#{type}")
    List<SongList> getSongListByType(String type);

    /**
     * 获取所有歌曲类型名
     * @return List<SongType>
     */
    @Select("SELECT * FROM song_type ORDER BY song_count DESC")
    List<SongType> getAllType();

    /**
     * 新增一个类型type
     * @param songType
     */
    @Insert("INSERT INTO song_type VALUES(#{typeId},#{typeName},#{songCount},#{deleteFlag},#{updateTime},#{createTime},#{type})")
    void addType(SongType songType);

    /**
     * 删除类型，将delete_flag改为1
     * @param typeName
     * @return
     */
    @Update("UPDATE song_type SET delete_flag = 1 WHERE type_name = #{typeName}")
    void deleteType(String typeName);
}
