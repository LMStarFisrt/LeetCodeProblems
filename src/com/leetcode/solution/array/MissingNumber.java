package com.leetcode.solution.array;

import java.util.Arrays;

/**
 * 给出一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 案例 1
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * <p>
 * <p>
 * 案例 2
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * <p>
 * <p>
 * 注意事项:
 * 您的算法应该以线性复杂度运行。你能否仅使用恒定的额外空间复杂度来实现它？
 *
 * @author dadisdad
 * @date 2018/4/26
 */
public class MissingNumber {

    /**
     * 排序后比较
     *
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] a = Arrays.copyOf(nums, nums.length);
        Arrays.sort(a);
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != result) {
                return result;
            } else {
                result += 1;
            }
        }
        return result;
    }

    /**
     * 0到n的和为 n(n+1)/2
     * 用这个和减去每个元素的值，差即为缺失的数字
     *
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println(missingNumber1(nums1));
        System.out.println(missingNumber1(nums2));

        System.out.println(missingNumber2(nums1));
        System.out.println(missingNumber2(nums2));

    }
}
