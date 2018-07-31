package com.leetcode.solution.array;

public class MaxArea {

    /**
     * O(n^2)
     *
     * @param nums
     * @return
     */
    public static int maxArea(int[] nums) {
        int max = getArea(nums, 0, 1);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (max < getArea(nums, i, j)) {
                    max = getArea(nums, i, j);
                }
            }
        }
        return max;
    }

    /**
     * O(n)
     *
     * @param nums
     * @return
     */
    public static int maxAreaII(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Integer.max(maxArea, getArea(nums, left, right));
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    private static int getArea(int[] nums, int i, int j) {
        return (j - i) * Integer.min(nums[i], nums[j]);
    }

    public static void main(String[] args) {
        System.out.println(maxAreaII(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
