package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.service.SongTypeService;
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
@RequestMapping("/songType")
public class SongTypeController {
    @Resource
    private SongTypeService songTypeService;

    @GetMapping(value = "/all")
    public List<Map<String,Object>> getAllType(){
        return songTypeService.getAllType();
    }

    @PostMapping(value = "/add")
    public void addType(@Param("typeName") String typeName){
        songTypeService.addType(typeName);
    }

    @DeleteMapping(value = "/delete")
    public void deleteType(@Param("typeName") String typeName){
        songTypeService.deleteType(typeName);
    }

}
