package com.leetcode.solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 说明:
 *
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
 * 示例:
 *
 * 给定完美二叉树，
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * 调用你的函数后，该完美二叉树变为：
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 *
 * @author dadisdad
 * @date 2018/5/9
 */
public class Connect {

    /**
     * 非递归
     *
     * @param root
     */
    public static void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> list = new LinkedList<>();
        list.offerLast(root);
        while (!list.isEmpty()) {
            List<TreeLinkNode> cc = new ArrayList<>();
            int count = list.size();
            while (count != 0) {
                TreeLinkNode temp = list.poll();
                cc.add(temp);
                count--;
                if (temp.left != null) {
                    list.offerLast(temp.left);
                }
                if (temp.right != null) {
                    list.offerLast(temp.right);
                }
            }
            for (int i = 0; i < cc.size(); i++) {
                if (i == cc.size() - 1) {
                    cc.get(i).next = null;
                } else {
                    cc.get(i).next = cc.get(i + 1);
                }
            }
        }
    }

    /**
     * 递归
     *
     * @param root
     */
    public static void connect1(TreeLinkNode root) {
        if (root != null) {
            if (root.left != null) {
                /**
                 * 兄弟节点
                 */
                root.left.next = root.right;

                /**
                 * 非兄弟相邻节点
                 */
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
            }
            connect(root.left);
            connect(root.right);
        }
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        connect(n1);

        System.out.println(n1.next);
    }
}
