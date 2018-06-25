package com.leetcode.solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树
 * <pre>
 * struct TreeLinkNode {
 *  TreeLinkNode *left;
 *  TreeLinkNode *right;
 *  TreeLinkNode *next;
 * }
 * </pre>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 说明:
 * <p>
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 示例:
 * <p>
 * 给定二叉树，
 * <pre>
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * 调用你的函数后，该二叉树变为：
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 * </pre>
 *
 * @author dadisdad
 * @date 2018/6/25
 */
public class ConnectII {

    public static void connectII(TreeLinkNode root) {
        if (root != null) {
            LinkedList<TreeLinkNode> list = new LinkedList<>();
            list.offerLast(root);
            visit(list);
        }
    }

    public static void visit(LinkedList<TreeLinkNode> list) {
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

}
