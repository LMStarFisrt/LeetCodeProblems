package com.leetcode.solution.math;

/**
 * 给出一个整数，写一个函数来确定这个数是不是3的一个幂。
 * 后续挑战：
 * 你能不使用循环或者递归完成本题吗？
 *
 * @author dadisdad
 * @date 2018/4/25
 */
public class IsPowerOfThree {

    /**
     * 小于等于0的数都不是
     * 1是3的幂
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree1(int n) {
        if (n <= 0) {
            return false;
        }
        for (int i = n; i > 1; i = i / 3) {
            if (i % 3 != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        } else if (n % 3 == 0) {
            return isPowerOfThree2(n / 3);
        } else {
            return false;
        }
    }

    /**
     *                log10^n
     * res = log3^n = -------
     *                log10^3
     *
     * res-(int)res==0，则为3的幂
     * @param n
     * @return
     */
    public static boolean isPowerOfThree3(int n) {
        double value = Math.log10(n)/Math.log10(3);
        return value-(int)value==0?true:false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree1(6));
        System.out.println(isPowerOfThree2(243));
        System.out.println(isPowerOfThree3(243));

    }
}
