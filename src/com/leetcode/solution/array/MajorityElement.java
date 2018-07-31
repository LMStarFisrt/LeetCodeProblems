package com.leetcode.solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <pre>
 * 输入: [3,2,3]
 * 输出: 3
 * </pre>
 * 示例 2:
 * <pre>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * </pre>
 *
 * @author dadisdad
 * @date 2018/6/28
 */
public class MajorityElement {

    public static int majorityElementI(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                res = entry.getKey();
            }
        }
        return res;
    }

    public static int majorityElementII(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) {
                    break;
                }
                if ((num & (1 << i)) != 0) {
                    ++ones;
                } else {
                    ++zeros;
                }
            }
            if (ones > zeros) {
                res |= (1 << i);
            }
        }
        return res;
    }

    public static int majorityElementIII(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                res = num;
                ++cnt;
            } else if (num == res) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return res;
    }

}
