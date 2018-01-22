package com.leetcode.solution.array;

/**
 * @author dadisdad
 * @date 2018/1/21
 */
public class RemoveDuplicatesfromSortedArray {

    /**
     * 在一个排好序的数组中，去除重复数据，返回新的数组长度，不允许开辟新的空间
     * It doesn't matter what you leave beyond the new length
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int m = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[m]) {
                m++;
                nums[m] = nums[i];
            }
        }
        return m + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 6, 7};

        /**
         * should return new length 7 with [1,2,3,4,5,6,7]
         */
        removeDuplicates(a);
    }

}
