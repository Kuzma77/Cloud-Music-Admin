package com.soft1851.music.admin.service.impl;

import com.soft1851.music.admin.service.FileService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public Map<String, String> exportSongList() {
        Map<String,String> map = new LinkedHashMap<>();
        String[] names = {"歌曲Id","歌曲名称","排序Id","歌手","时长","封面图","歌曲地址","歌词","评论量","收藏量","播放量","删除标志","修改时间","创建时间"};
        String[] field = {"song_id", "song_name", "sort_id", "singer", "duration", "thumbnail", "url", "lyric", "comment_count", "like_count", "play_count", "delete_flag", "update_time", "create_time"};
        int len = names.length;
        for (int i = 0;i<len;i++){
            map.put(field[i],names[i]);
        }
        return map;
    }
}
