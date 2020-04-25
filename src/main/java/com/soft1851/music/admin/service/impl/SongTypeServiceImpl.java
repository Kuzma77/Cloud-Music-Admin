package com.soft1851.music.admin.service.impl;

import com.soft1851.music.admin.entity.SongType;
import com.soft1851.music.admin.mapper.SongTypeMapper;
import com.soft1851.music.admin.service.SongTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class SongTypeServiceImpl extends ServiceImpl<SongTypeMapper, SongType> implements SongTypeService {

    @Resource
    private SongTypeMapper songTypeMapper;
    @Override
    public List<Map<String,Object>> getAllType() {
        List<SongType> songTypes = songTypeMapper.getAllType();
        List<Map<String,Object>> maps = new ArrayList<>();
        songTypes.forEach(songType -> {
            Map<String, Object> map = new HashMap<>(8);
            if(("其它").equals(songType.getTypeName())){
                map.put("type_name",songType.getTypeName());
                map.put("song_lists",songTypeMapper.getSongListByType("0"));
                map.put("delete_flag",songType.getDeleteFlag());
            }else {
                map.put("type_name",songType.getTypeName());
                map.put("song_lists",songTypeMapper.getSongListByType(songType.getTypeName()));
                map.put("delete_flag",songType.getDeleteFlag());
            }
            maps.add(map);
        });
        return maps;
    }
}
