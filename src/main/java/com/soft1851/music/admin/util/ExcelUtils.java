package com.soft1851.music.admin.util;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.exception.CustomException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
@Slf4j
public class ExcelUtils {
    public static void exportExcel(HttpServletResponse response, List list, Map<String,String> map,String title){
        ExcelWriter writer = ExcelUtil.getWriter(true);
        Set<Map.Entry<String,String>> entries = map.entrySet();
        Iterator<Map.Entry<String,String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> next = iterator.next();
            writer.addHeaderAlias(next.getKey(),next.getValue());
        }
        writer.merge(map.size() - 1,title);
        writer.write(list,true);
        try {
            writer.flush(response.getOutputStream(),true);
        }catch (IOException e){
            log.info("导出异常");
            throw  new CustomException("歌单数据导出异常", ResultCode.DATABASE_EXPORT_ERROR);
        }
        writer.close();
    }
}
