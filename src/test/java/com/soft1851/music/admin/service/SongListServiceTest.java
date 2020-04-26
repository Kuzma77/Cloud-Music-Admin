package com.soft1851.music.admin.service;

import com.soft1851.music.admin.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SongListServiceTest {
@Resource
private SongListService songListService;
    @Test
    void getByPage() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(10)
                .build();
        songListService.getByPage(pageDto);
    }

    @Test
    void selectSongsBySongListId() {
        System.out.println(songListService.selectSongsBySongListId("100712280"));
    }
}