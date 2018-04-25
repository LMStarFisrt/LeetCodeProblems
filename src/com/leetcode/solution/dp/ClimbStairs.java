package com.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 步 + 1 步
 * 2.  2 步
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 步 + 1 步 + 1 步
 * 2.  1 步 + 2 步
 * 3.  2 步 + 1 步
 * <p>
 * <p>
 * 爬楼梯是经典的动态规划题，经分析可得：F(n) = F(n-1)+F(n-2)
 *
 * @author dadisdad
 * @date 2018/4/25
 */
public class ClimbStairs {

    /**
     * 可以使用递归，但是时间复杂度是O(2^n)
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    static Map<Integer, Integer> map = new HashMap<>();

    /**
     * 备忘录算法，将之前的结果保存到hashMap 中
     * <p>
     * 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = climbStairs2(n - 1) + climbStairs2(n - 2);
            map.put(n, value);
            return value;
        }
    }

    /**
     * 自底向上，迭代推导
     * <p>
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(10));
        System.out.println(climbStairs2(10));
        System.out.println(climbStairs3(10));
    }
}
