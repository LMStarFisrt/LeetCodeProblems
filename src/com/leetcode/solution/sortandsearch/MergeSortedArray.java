package com.leetcode.solution.sortandsearch;

/**
 * 两个排好序的整数数组 A B，把B合并到A中成为一个有序的数组
 * m 和 n是A、B数组的初始元素个数
 *
 * @author dadisdad
 * @date 2018/1/22
 */
public class MergeSortedArray {

    /**
     * A个数m，B个数n，合并之后个数肯定为m+n
     * 从后往前遍历A，B，谁大就放到k这里，同时递减k。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
            } else if (i >= 0) {
                nums1[k] = nums1[i];
                i--;
            } else if (j >= 0) {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7, 0, 0, 0, 0};
        int[] b = new int[]{2, 4, 6, 8};
        merge(a, 4, b, 4);
    }
}
