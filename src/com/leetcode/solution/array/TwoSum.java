package com.leetcode.solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dadisdad
 * @date 2017/10/31
 */
public class TwoSum {

    /**
     * O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] addTwoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Not found!");
    }

    /**
     * O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] addTwoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp) && map.get(comp) != i) {
                return new int[]{i, map.get(comp)};
            }
        }
        throw new IllegalArgumentException("Not found!");
    }

    /**
     * O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] addTwoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[]{i, map.get(comp)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Not found!");
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] indexs = addTwoSum3(nums, target);
        System.out.println(indexs[0]);
        System.out.println(indexs[1]);
    }
}
