package com.leetcode.solution.tree;

import com.leetcode.solution.util.TreeUtils;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <pre>
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * </pre>
 * 示例 2:
 * <pre>
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * </pre>
 * 示例 3:
 * <pre>
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 * </pre>
 *
 * @author dadisdad
 * @date 2018/6/27
 */
public class IsSameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        } else {
            if (q == null) {
                return false;
            } else {
                if (p.val != q.val) {
                    return false;
                } else {
                    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode p = TreeUtils.deserialize("1,2,3");
        TreeNode q = TreeUtils.deserialize("1,1,3");
        System.out.println(isSameTree(p, q));
    }
}
