package com.leetcode.solution.math;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 注意：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 16
 * <p>
 * 输出： True
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入： 14
 * <p>
 * 输出： False
 *
 * @author dadisdad
 * @date 2018/6/15
 */
public class IsPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int mid = num / 2;
        for (int i = 1; i <= mid; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }
}
