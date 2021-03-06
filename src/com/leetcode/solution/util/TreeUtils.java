package com.leetcode.solution.util;

import com.leetcode.solution.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 树工具类
 *
 * @author dadisdad
 * @date 2018/6/13
 */
public class TreeUtils {

    /**
     * 节点转换字符串
     *
     * @param node
     * @return
     */
    public static String nodeToString(TreeNode node) {
        return node == null ? null : node.val + "";
    }

    /**
     * 树的深度
     *
     * @param root
     * @return
     */
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left > right ? left : right) + 1;
    }

    /**
     * 树转成字符串
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        int treeDepth = TreeUtils.treeDepth(root);
        List<String> list = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty() && treeDepth > 0) {
            int count = nodes.size();
            while (count != 0) {
                TreeNode p = nodes.poll();
                if (p != null) {
                    list.add(String.valueOf(p.val));
                    nodes.offerLast(p.left);
                    nodes.offerLast(p.right);
                } else {
                    list.add("null");
                }
                count--;
            }
            treeDepth--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb = sb.append(list.get(i));
            } else {
                sb = sb.append(list.get(i) + ",");
            }
        }
        return sb.toString();
    }

    /**
     * 根据字符串构造树
     */
    public static TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        // 分割
        String[] nodes = data.split(",");
        // 初始化节点
        List<TreeNode> treeNodes = new ArrayList<>(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals("null")) {
                treeNodes.add(null);
            } else {
                treeNodes.add(new TreeNode(Integer.valueOf(nodes[i])));
            }
        }
        TreeNode root = treeNodes.get(0);

        // 按层次将节点分组
        List<List<TreeNode>> levelNodes = new ArrayList<>();
        // 本层开始索引
        int levelStart = 0;
        // 本层结束索引
        int levelEnd = 0;
        // 下一层节点数
        int nextLevelCount;

        int i = 0;
        while (i < treeNodes.size()) {
            // 空节点数
            int nullCount = 0;
            // 本层节点数
            int nodeCount = 0;
            List<TreeNode> tmpNodes = new ArrayList<>();
            for (int j = levelStart; j <= levelEnd; j++) {
                if (treeNodes.get(j) == null) {
                    nullCount++;
                }
                nodeCount++;
                tmpNodes.add(treeNodes.get(j));
            }
            nextLevelCount = (nodeCount - nullCount) * 2;
            levelStart = i + 1;
            levelEnd = i + nextLevelCount;
            levelNodes.add(tmpNodes);
            i = i + nextLevelCount;
        }
        // 按层次构造树
        for (int j = 0; j < levelNodes.size() - 1; j++) {
            List<TreeNode> treeNodeList = levelNodes.get(j);
            // 下一层节点指针
            int nextLevelNodePoint = 0;
            for (int k = 0; k < treeNodeList.size(); k++) {
                TreeNode node = treeNodeList.get(k);
                if (node != null) {
                    List<TreeNode> nextLevelTreeNodeList = levelNodes.get(j + 1);
                    node.left = nextLevelTreeNodeList.get(nextLevelNodePoint++);
                    node.right = nextLevelTreeNodeList.get(nextLevelNodePoint++);
                }
            }
        }
        return root;
    }
}
