package com.leetcode.solution.array;

import java.util.Arrays;

/**
 * 将包含 n 个元素的数组向右旋转 k 步。
 * <p>
 * 例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 *
 * @author 10308
 * @date 2018/4/10
 */
public class RorateArray {

    /**
     * 解法1：
     * 旋转1步，其实就是将最后一位放到第一位，其他位置的数的位置提高一位。
     * 复杂度O(kn)
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        while (k != 0) {
            int end = nums[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = end;
            k--;
        }
    }

    /**
     * 解法2：
     * 将数组以k分为两部分，先旋转左右两部分，再旋转整个数组。
     * 复杂度O(n)
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        if (k > 0) {
            int turn = k % n;
            int middle = n - turn;
            reverse(nums, 0, middle - 1);
            reverse(nums, middle, n - 1);
            reverse(nums, 0, n - 1);
        }
    }

    public static void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums1 = {1};
        int[] nums2 = {1, 2};
        int k = 3;
        System.out.println(Arrays.toString(nums2));
        rotate2(nums2, k);
        System.out.println(Arrays.toString(nums2));
    }
}
