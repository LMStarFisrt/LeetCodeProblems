package com.leetcode.solution.array;

/**
 * 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <pre>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * </pre>
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * @author dadisdad
 * @date 2018/9/5
 */
public class MinSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int j = -1;
        int sum = 0;
        int len = 0;
        int min_len = 0;
        while (i < nums.length && j < nums.length) {
            if (sum >= s) {
                sum = sum - nums[i];
                len = j - i + 1;
                if (min_len == 0) {
                    min_len = len;
                } else {
                    min_len = Integer.min(min_len, len);
                }
                i++;
            } else {
                j++;
                if (j <= nums.length - 1) {
                    sum += nums[j];
                }
            }
        }
        return min_len;
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
