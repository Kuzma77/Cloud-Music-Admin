package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.entity.SongType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SongTypeMapperTest {
    @Resource
    private SongTypeMapper songTypeMapper;

    @Test
    void getSongListByType() {
    }

    @Test
    void getAllType() {
        List<SongType> songTypes = songTypeMapper.getAllType();
        songTypes.forEach(System.out::println);
    }
}