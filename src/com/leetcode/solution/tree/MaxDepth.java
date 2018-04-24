package com.leetcode.solution.tree;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <br>
 * 3        <br>
 * / \       <br>
 * 9  20      <br>
 * /  \     <br>
 * 15   7    <br>
 * 返回它的最大深度 3 。
 *
 * @author dadisdad
 * @date 2018/4/24
 */
public class MaxDepth {

    /**
     * 递归调用，判断左右子树最大深度哪一个更大
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right ? left : right) + 1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        System.out.println(maxDepth(n1));

    }
}
