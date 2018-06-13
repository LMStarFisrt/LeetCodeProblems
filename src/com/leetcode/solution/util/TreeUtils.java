package com.leetcode.solution.util;

import com.leetcode.solution.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树工具类
 *
 * @author dadisdad
 * @date 2018/6/13
 */
public class TreeUtils {

    /**
     * 根据数组构造一颗树<br>
     * 例如：[3,9,20,null,null,15,7]
     * <pre>
     *        3
     *       / \
     *      9  20
     *        /  \
     *       15  7
     * </pre>
     *
     * @param arrays
     * @return
     */
    public static TreeNode buildTree(Integer[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            return null;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                treeNodes.add(new TreeNode(arrays[i]));
            } else {
                treeNodes.add(null);
            }
        }
        int size = treeNodes.size();
        for (int i = 0; i < size; i++) {
            if (2 * i + 1 < size) {
                treeNodes.get(i).left = treeNodes.get(2 * i + 1);
            }
            if (2 * i + 2 < size) {
                treeNodes.get(i).right = treeNodes.get(2 * i + 2);
            }
        }
        return treeNodes.get(0);
    }

    /**
     * 节点转换字符串
     *
     * @param node
     * @return
     */
    public static String nodeToString(TreeNode node) {
        return node == null ? null : node.val + "";
    }

}
