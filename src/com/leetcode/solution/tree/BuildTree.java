package com.leetcode.solution.tree;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author dadisdad
 * @date 2018/5/7
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd || preEnd < preStart) {
            return null;
        }
        int flag = 0;
        TreeNode res = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]) {
                flag = i;
                break;
            }
        }
        res.left = buildTree(preorder, inorder, preStart + 1, preStart + flag - inStart, inStart, flag - 1);
        res.right = buildTree(preorder, inorder, preStart + flag - inStart + 1, preEnd, flag + 1, inEnd);
        return res;
    }
}
