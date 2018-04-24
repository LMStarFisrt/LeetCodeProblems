package com.leetcode.solution.tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @author dadisdad
 * @date 2018/4/24
 */
public class SortedArrayToBST {

    /**
     * 平衡二叉搜索树的根结点的值正好是所有节点值的中间值，
     * 即中序遍历时，根结点位于正中间（因为是平滑二叉树）
     * （如果是偶数个结点，则位于最中间两个靠前的那个）。
     * 于是可以想到使用二分法，先把有序数组的最中间值设为根结点，
     * 然后根结点的左孩子是左半段数组的最中间值，根结点的右孩子是右半段数组的最中间值。
     * 依次这样，即可以建立一个平衡二叉搜索树。
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
