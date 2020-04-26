package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongList;
import com.soft1851.music.admin.mapper.SongListMapper;
import com.soft1851.music.admin.mapper.SongMapper;
import com.soft1851.music.admin.service.SongListService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/songList")
public class SongListController {
    @Resource
    private SongListMapper songListMapper;
    @Resource
    private SongListService songListService;
    @PostMapping(value = "/getByPage")
    public Map<String,Object> getSongListByPage(@RequestBody PageDto pageDto){
        return songListService.getByPage(pageDto);
    }
    @GetMapping(value = "/all")
    public List<SongList> getAllSongList(){
        return songListMapper.getAll();
    }
    @GetMapping(value = "/getSongList")
    public Map<String, Object> getSongListById(@Param("SongListId") String songListId){
        return songListService.selectSongsBySongListId(songListId);
    }
}
