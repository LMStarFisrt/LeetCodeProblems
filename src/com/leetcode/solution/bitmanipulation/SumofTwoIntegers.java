package com.leetcode.solution.bitmanipulation;

/**
 * 在不使用+ -号对两个数进行相加
 *
 * @author dadisdad
 * @date 2018/1/22
 */
public class SumofTwoIntegers {

    /**
     * 使用二进制来解决
     * <br>
     * 例如：5+3 二进制为 0101+0011
     * 结果应为8（1000）
     * 先进行与 得到产生进位的那一位 0001
     * 再进行异或 得到未加进位的结果 0110
     * 将0001左移一位与0110相加
     * 循环上面的步骤 直到没有进位
     * <p>
     * 其实就是将进位加操作拆分成一步步进位，直到没有进位为止
     *
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(0, 0));
        System.out.println(getSum(0, 34));
        System.out.println(getSum(24, 0));
        System.out.println(getSum(1, 3));
        System.out.println(getSum(23, 39));
    }
}
