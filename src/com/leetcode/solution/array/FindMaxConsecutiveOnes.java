package com.leetcode.solution.array;

/**
 * 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <pre>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * </pre>
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * @author dadisdad
 * @date 2018/9/5
 */
public class FindMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                res = Integer.max(res, count);
                count = 0;
            } else {
                count++;
            }
        }
        return Integer.max(res, count);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
