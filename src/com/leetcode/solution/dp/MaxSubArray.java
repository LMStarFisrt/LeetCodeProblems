package com.leetcode.solution.dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author dadisdad
 * @date 2018/4/25
 */
public class MaxSubArray {

    /**
     * 循环找出所有子数组的和，返回最大值
     * 时间复杂度O(n^3)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int tempSum = 0;
                for (int k = i; k <= j; k++) {
                    tempSum += nums[k];
                }
                maxSum = Math.max(maxSum, tempSum);
            }
        }
        return maxSum;
    }

    /**
     * 第一层用来找到每个可能的子序列的起点，
     * 而第二个循环直接从第一层确定的起点往数组结尾遍历，
     * 在遍历的过程中同时也计算序列值。
     * <p>
     * 时间复杂度O(n^2)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            for (int j = i; j < nums.length; j++) {
                tempSum += nums[j];
                maxSum = Math.max(maxSum, tempSum);
            }
        }
        return maxSum;
    }

    /**
     * 最大子序列和是连续的子序列
     * ThisSum[i]表示第i处，以A[i]结尾的子序列的最大和。
     * 则状态方程为ThisSum[i]=max(ThisSum[i-1]+nums[i],nums[i])
     * <p>
     * 也即是说，如果ThisSum[i-1]<0则ThisSum[i]就是nums[i],否则ThisSum[i]=nums[i]+ThisSum[i-1]（因为是以i结尾的
     * 时间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        int maxSum = nums[0];
        int thisSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (thisSum < 0) {
                thisSum = nums[i];
            } else {
                thisSum += nums[i];
            }
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-2};
        System.out.println(maxSubArray1(nums1));
        System.out.println(maxSubArray2(nums1));
        System.out.println(maxSubArray3(nums1));

        System.out.println(maxSubArray1(nums2));
        System.out.println(maxSubArray2(nums2));
        System.out.println(maxSubArray3(nums2));
    }

}
