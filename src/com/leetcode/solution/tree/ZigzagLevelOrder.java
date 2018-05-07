package com.leetcode.solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author dadisdad
 * @date 2018/5/7
 */
public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        int level = 0;
        while (!list.isEmpty()) {
            List<Integer> cc = new ArrayList<>();
            int count = list.size();
            while (count != 0) {
                TreeNode temp;
                if (level%2==0) {
                    temp = list.pollLast();
                    if (temp.left != null) {
                        list.offerFirst(temp.left);
                    }
                    if (temp.right != null) {
                        list.offerFirst(temp.right);
                    }
                }else {
                    temp = list.pollFirst();
                    if (temp.right != null) {
                        list.offerLast(temp.right);
                    }
                    if (temp.left != null) {
                        list.offerLast(temp.left);
                    }
                }
                cc.add(temp.val);
                count--;
            }
            level++;
            result.add(cc);
        }
        return result;
    }

}
