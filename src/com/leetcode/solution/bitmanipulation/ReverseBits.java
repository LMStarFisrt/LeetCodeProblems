package com.leetcode.solution.bitmanipulation;

/**
 * 颠倒给定的32位无符号整数的二进制位。
 * <p>
 * 例如，给定输入 43261596（二进制表示为 00000010100101000001111010011100 ），返回 964176192（二进制表示为 00111001011110000010100101000000）。
 * <p>
 * 问题进阶:
 * 如果多次调用这个函数，你将如何优化它？
 *
 * @author dadisdad
 * @date 2018/4/26
 */
public class ReverseBits {

    /**
     *
     *
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        int result = 0;
        int i = 0;
        while (i < 32) {
            result = result << 1;
            /**
             * 注意+ & 符号的优先级
             */
            result = result + (n & 1);
            n = n >> 1;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(reverseBits(1));
    }
}
