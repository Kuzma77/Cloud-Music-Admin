package com.soft1851.music.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.Song;
import com.soft1851.music.admin.entity.SongList;
import com.soft1851.music.admin.mapper.SongListMapper;
import com.soft1851.music.admin.mapper.SongMapper;
import com.soft1851.music.admin.service.SongListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
@Service
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList> implements SongListService {
@Resource
private SongListMapper songListMapper;
@Resource
private SongMapper songMapper;
    @Override
    public Map<String,Object> getByPage(PageDto pageDto) {
        Page<SongList> page = new Page<>(pageDto.getCurrentPage(),pageDto.getPageSize());
        QueryWrapper<SongList> wrapper = new QueryWrapper<>();
        IPage<SongList> iPage = songListMapper.selectPage(page,wrapper);
        Map<String, Object> map = new HashMap<>(8);
        map.put("singLists",iPage.getRecords());
        map.put("totalPage",iPage.getPages());
        return map;
    }

    @Override
    public Map<String, Object> selectSongsBySongListId(String songListId) {
        Map<String, Object> map = new HashMap<>(8);
        SongList songList = songListMapper.selectBySongListId(songListId);
        List<Song> songs = songMapper.getSongsBySongListId(songList.getSongListId());
        map.put("songList",songList);
        map.put("songs",songs);
        return map;
    }
}
