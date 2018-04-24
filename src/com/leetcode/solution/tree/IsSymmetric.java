package com.leetcode.solution.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * @author dadisdad
 * @date 2018/4/24
 */
public class IsSymmetric {

    /**
     * （设二叉树左子树为p，右子树为q，p、q均指向左右子树的根）
     * 递归：p和q的值相等，并且p的左子树与q的右子树对称，p的右子树与q的左子树对称
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    private static boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        return (left.val == right.val) && symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }

    /**
     * 非递归。利用双端队列
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        /**
         * 空树
         */
        if (root == null) {
            return true;
        }
        /**
         * 单节点树
         */
        if (root.left == null && root.right == null) {
            return true;
        }
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offerFirst(root.left);
        list.offerLast(root.right);
        while (!list.isEmpty()) {
            /**
             * 拿出首尾，判断是否相等
             */
            TreeNode lnode = list.getFirst();
            TreeNode rnode = list.getLast();
            list.pollFirst();
            list.pollLast();
            if (lnode.val != rnode.val) {
                return false;
            }
            /**
             * 判断lnode 的左子树与rnode的右子树 null的清况
             */
            if ((lnode.left == null && rnode.right != null) || (lnode.left != null && rnode.right == null)) {
                return false;
            }
            /**
             * lnode左子树不为空，则rnode的右子树也不为空
             * 将lnode左子树放到队头，rnode的右子树放到队尾
             */
            if (lnode.left != null) {
                list.offerFirst(lnode.left);
                list.offerLast(rnode.right);
            }
            if ((lnode.right == null && rnode.left != null) || (lnode.right != null && rnode.left == null)) {
                return false;
            }
            if (lnode.right != null) {
                list.offerFirst(lnode.right);
                list.offerLast(rnode.left);
            }
        }
        return true;
    }
}
