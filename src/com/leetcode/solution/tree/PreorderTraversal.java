package com.leetcode.solution.tree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author dadisdad
 * @date 2018/5/9
 */
public class PreorderTraversal {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private static void preOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preOrder(root.left, result);
            preOrder(root.right, result);
        }
    }

    /**
     * 栈中仅仅保存右节点，因为是前序遍历，左节点可以直接输出
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null){
            return result;
        }
        TreeNode curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            result.add(curr.val);
            if (curr.right!=null){
                stack.push(curr.right);
            }
            if (curr.left!=null){
                curr = curr.left;
            }else {
                curr = stack.pop();
            }
        }
        return result;
    }

    /**
     * 1.选择一个root节点
     *
     * 2.将其左节点依次加入栈中
     *
     * 3.输出栈顶节点，弹出，然后将root设置为其右节点，重复1步骤
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                result.add(curr.val);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }

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

        System.out.println(Arrays.toString(preorderTraversal3(n1).toArray()));
    }
}
