package com.leetcode.solution.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author dadisdad
 * @date 2018/5/10
 */
public class PostorderTraversal {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalResc(root, result);
        return result;
    }

    private static void postorderTraversalResc(TreeNode root, List<Integer> result) {
        if (root != null) {
            postorderTraversalResc(root.left, result);
            postorderTraversalResc(root.right, result);
            result.add(root.val);
        }
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (root == null) {
            return result;
        }
        TreeNode curr = root;
        stack1.push(curr);
        while (!stack1.isEmpty()) {
            curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(Arrays.toString(postorderTraversal(n1).toArray()));
        System.out.println(Arrays.toString(postorderTraversal1(n1).toArray()));
    }
}
