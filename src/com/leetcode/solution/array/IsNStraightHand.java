package com.leetcode.solution.array;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 846. 一手顺子
 * 用户通过次数 25
 * 用户尝试次数 39
 * 通过次数 25
 * 提交次数 97
 * 题目难度 Medium
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 *
 *
 * 提示：
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 *
 * @author dadisdad
 * @date 2018/6/3
 */
public class IsNStraightHand {

    public static boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (!map.isEmpty()) {
            int first = map.firstKey();
            for (int i = 0; i < W; i++) {
                if (map.getOrDefault(first + i, 0) == 0) {
                    return false;
                }
                map.put(first + i, map.getOrDefault(first + i, 0) - 1);
                if (map.get(first + i) == 0) {
                    map.remove(first + i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 2);
    }
}
