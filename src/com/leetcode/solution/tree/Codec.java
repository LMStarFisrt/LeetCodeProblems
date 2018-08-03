package com.leetcode.solution.tree;

import com.leetcode.solution.util.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化及反序列化
 *
 * @author dadisdad
 * @date 2018-07-31
 */
public class Codec {

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
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
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
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

    public static void main(String[] args) {
        //[1,2,3,null,null,4,5,6,null,8,9,11,45,46,null,47,48]
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        TreeNode g = new TreeNode(9);
        TreeNode h = new TreeNode(11);
        TreeNode i = new TreeNode(45);
        TreeNode j = new TreeNode(46);
        TreeNode k = new TreeNode(47);
        TreeNode l = new TreeNode(48);

        root.left = a;
        root.right = b;

        b.left = c;
        b.right = d;

        c.left = e;

        d.left = f;
        d.right = g;

        e.left = h;
        e.right = i;

        f.left = j;

        g.left = k;
        g.right = l;

        Codec codec = new Codec();
        System.out.println(codec.deserialize(codec.serialize(root)));
    }
}
