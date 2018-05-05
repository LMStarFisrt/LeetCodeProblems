package com.leetcode.solution.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @author dadisdad
 * @date 2018/5/5
 */
public class Permute {


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>());
        return result;
    }

    private static void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                backtracking(nums, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.deepToString(permute(nums).toArray()));
    }
}
