package com.leetcode.solution.array;

import java.util.Arrays;

/**
 * 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * <pre>
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * </pre>
 * 提示:
 * <p>
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 *
 * @author dadisdad
 * @date 2018/9/4
 */
public class ArrayPairSum {

    public static int arrayPairSumI(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static int arrayPairSumII(int[] nums) {
        int[] index = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            index[nums[i] + 10000]++;
        }

        int res = 0;
        boolean odd = true;
        for (int i = 0; i < index.length; i++) {
            while (index[i] > 0) {
                if (odd) {
                    res += i - 10000;
                }
                odd = !odd;
                index[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
