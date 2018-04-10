package com.leetcode.solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
 *
 * @author 10308
 * @date 2018/4/10
 */
public class ContainsDuplicate {

    /**
     * 将元素放到Map中，如果已经存在，则有重复
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(containsDuplicate(nums));
    }
}
