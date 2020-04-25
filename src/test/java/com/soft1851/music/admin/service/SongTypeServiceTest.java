package com.soft1851.music.admin.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SongTypeServiceTest {
@Resource SongTypeService songTypeService;
    @Test
    void getAllType() {
        List<Map<String,Object>> list = songTypeService.getAllType();
        list.forEach(System.out::println);
    }
}