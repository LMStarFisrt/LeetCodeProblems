package com.leetcode.solution.tree;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <pre>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * @author dadisdad
 * @date 2018/6/25
 */
public class BuildTreeInPost {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode res = new TreeNode(postorder[postEnd]);
        int pos = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (postorder[postEnd] == inorder[i]) {
                pos = i;
                break;
            }
        }
        res.left = buildTree(inorder, inStart, pos - 1, postorder, postStart, postStart + pos - 1 - inStart);
        res.right = buildTree(inorder, pos + 1, inEnd, postorder, postEnd - inEnd + pos, postEnd - 1);
        return res;
    }

}
