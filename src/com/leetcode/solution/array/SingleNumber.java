package com.leetcode.solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，除了某个元素外其余元素均出现两次。请找出这个只出现一次的元素。
 *
 * @author 10308
 * @date 2018/4/11
 */
public class SingleNumber {

    /**
     * 通过Map保存计数
     *
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int nu = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], count);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
                ) {
            if (entry.getValue() == 0) {
                nu = entry.getKey();
            }
        }
        return nu;
    }

    /**
     * 利用异或
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = nums[i]^result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4};
        System.out.println(singleNumber2(nums));
    }

}
