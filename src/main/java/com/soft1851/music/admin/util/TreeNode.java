package com.soft1851.music.admin.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreeNode {
    private Integer id;

    private Integer parentId;

    private String title;

    private String icon;

    private String path;

    private Integer sort;

    private List<TreeNode> subMenus;

    public TreeNode(Integer id, Integer parentId, String title, String icon, String path, Integer sort) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
        this.icon = icon;
        this.path = path;
        this.sort = sort;
    }
}
