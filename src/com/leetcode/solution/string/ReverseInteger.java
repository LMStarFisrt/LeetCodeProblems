package com.leetcode.solution.string;

/**
 * 给定一个范围为 32 位 int 的整数，将其颠倒。
 * 假设我们的环境只能处理 32 位 int 范围内的整数。根据这个假设，如果颠倒后的结果超过这个范围，则返回 0。
 *
 * @author dadisdad
 * @date 2018/1/23
 */
public class ReverseInteger {

    public static int reverse(int x) {
        long result = 0L;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;

    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
        System.out.println(reverse(123));
        System.out.println(reverse(-321));
        System.out.println(reverse(1234567899));
    }
}
