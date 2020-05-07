package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.annotation.ControllerWebLog;
import com.soft1851.music.admin.service.SongService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wlsun
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/song")
public class SongController {
//    @Resource
//    private SongService songService;
//    @ControllerWebLog
//    @PostMapping(value = "/exportAll")
//    public void exportAll(){
//        songService.exportData();
//    }
}
