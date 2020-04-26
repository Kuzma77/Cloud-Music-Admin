package com.soft1851.music.admin.controller;

import cn.hutool.poi.excel.ExcelUtil;
import com.soft1851.music.admin.mapper.SongMapper;
import com.soft1851.music.admin.service.FileService;
import com.soft1851.music.admin.service.SongListService;
import com.soft1851.music.admin.util.ExcelUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
@RestController
@RequestMapping("/resources")
public class FileController {
    @Resource
    private SongMapper songMapper;
    @Resource
    private FileService fileService;
    @GetMapping(value = "/songs")
    @ResponseBody
    public void export(@Param("songListId") String songListId) throws IOException{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes !=null;
        HttpServletResponse response = attributes.getResponse();
        assert response !=null;
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition","attachment");
        ExcelUtils.exportExcel(response,songMapper.getSongsBySongListId(songListId),fileService.exportSongList(),"歌曲表"+songListId);
    }
}
