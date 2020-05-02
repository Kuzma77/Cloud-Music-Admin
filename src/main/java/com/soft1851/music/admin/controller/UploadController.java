package com.soft1851.music.admin.controller;

import com.soft1851.music.admin.annotation.ControllerWebLog;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.util.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wl_sun
 * @description TODO
 * @Data 2020/5/1
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class UploadController {

    @PostMapping("/uploadFile")
    @ControllerWebLog
    public ResponseResult uploadSingle(@RequestParam("file") MultipartFile sourceFile) {
        String url = AliOssUtil.upload(sourceFile);
        return ResponseResult.success(url);
    }
}
