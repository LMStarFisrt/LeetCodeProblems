package com.leetcode.solution.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author dadisdad
 * @date 2018/5/6
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private static void backtracking(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start) {
        List<Integer> temp = new ArrayList<>(tempList);
        System.out.println(Arrays.toString(temp.toArray()));
        result.add(temp);
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtracking(nums, result, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.deepToString(subsets(nums).toArray()));
    }
}
