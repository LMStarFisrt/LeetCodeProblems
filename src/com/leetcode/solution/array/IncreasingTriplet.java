package com.leetcode.solution.array;

import java.util.Arrays;

/**
 * 给定一个未排序的数组，请判断这个数组中是否存在长度为3的递增的子序列。
 *
 * 正式的数学表达如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 要求算法时间复杂度为O(n)，空间复杂度为O(1) 。
 *
 * 示例:
 * 输入 [1, 2, 3, 4, 5],
 * 输出 true.
 *
 * 输入 [5, 4, 3, 2, 1],
 * 输出 false.
 *
 * @author dadisdad
 * @date 2018/5/2
 */
public class IncreasingTriplet {

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet1(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] m1 = new int[nums.length];
        int[] m2 = new int[nums.length];
        Arrays.fill(m1, nums[0]);
        Arrays.fill(m2, nums[nums.length - 1]);

        for (int i = 1; i < nums.length; i++) {
            m1[i] = Math.min(m1[i - 1], nums[i]);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            m2[i] = Math.max(m2[i + 1], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1[i] && nums[i] < m2[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet3(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;

        for (int a : nums) {
            if (m1 >= a) {
                m1 = a;
            } else if (m2 >= a) {
                m2 = a;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet solution = new IncreasingTriplet();

        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 1, 5, 0, 4, 6};

        System.out.println(solution.increasingTriplet1(nums1));
        System.out.println(solution.increasingTriplet1(nums2));

        System.out.println(solution.increasingTriplet2(nums1));
        System.out.println(solution.increasingTriplet2(nums2));
    }
}
