package com.leetcode.solution.math;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author dadisdad
 * @date 2018/6/14
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int tmp = x;
            int res = 0;
            while (tmp > 0) {
                int a = tmp % 10;
                tmp = tmp / 10;
                res = res * 10 + a;
            }
            if (res == x) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-10));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(121));
    }
}
