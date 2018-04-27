package com.leetcode.solution.array;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author dadisdad
 * @date 2018/4/27
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.parallelSort(nums);
        List<List<Integer>> result =new ArrayList<>();
        if (nums.length < 3 || nums[0] > 0) {
            return result;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int toFind = 0 - (nums[i] + nums[j]);
                if (Arrays.binarySearch(nums, j + 1, nums.length, toFind) > -1) {
                    result.add(Arrays.asList(nums[i], nums[j], toFind));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {1,-1,-1,0};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
        System.out.println(Arrays.toString(threeSum(nums1).toArray()));
    }

}
