package com.leetcode.solution.array;

import com.leetcode.solution.util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author dadisdad
 * @date 2018/6/13
 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        if (ArrayUtils.isEmpty(numbers)) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}
