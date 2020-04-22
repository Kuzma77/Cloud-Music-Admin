package com.soft1851.music.admin.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
public class TreeBuilder {

    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static List<TreeNode> buildTreeByLoop(List<TreeNode> treeNodes) {

        List<TreeNode> trees = new ArrayList<>();

        for (TreeNode treeNode : treeNodes) {

            if (treeNode.getParentId() == 0) {
                trees.add(treeNode);
            }

            for (TreeNode it : treeNodes) {
                if (it.getParentId().equals(treeNode.getId())) {
                    if (treeNode.getSubMenus() == null) {
                        treeNode.setSubMenus(new ArrayList<>());
                    }
                    treeNode.getSubMenus().add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static List<TreeNode> buildTreeByRecursive(List<TreeNode> treeNodes) {
        List<TreeNode> trees = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.getParentId() == 0) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static TreeNode findChildren(TreeNode treeNode, List<TreeNode> treeNodes) {
        for (TreeNode it : treeNodes) {
            if (treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getSubMenus() == null) {
                    treeNode.setSubMenus(new ArrayList<>());
                }
                treeNode.getSubMenus().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
