package com.soft1851.music.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {
    private Integer currentPage;
    private Integer pageSize;
}
