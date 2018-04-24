package com.leetcode.solution.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author dadisdad
 * @date 2018/4/24
 */
public class LevelOrder {

    /**
     * 利用队列
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            List<Integer> cc = new ArrayList<>();
            int count = list.size();
            while (count != 0) {
                TreeNode temp = list.poll();
                cc.add(temp.val);
                count--;
                if (temp.left != null) {
                    list.offerLast(temp.left);
                }
                if (temp.right != null) {
                    list.offerLast(temp.right);
                }
            }
            result.add(cc);
        }
        return result;
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

        List<List<Integer>> list = levelOrder(n1);
        System.out.println(Arrays.toString(list.toArray()));
    }

}
