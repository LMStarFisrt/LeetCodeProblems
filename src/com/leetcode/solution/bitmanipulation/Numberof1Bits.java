package com.leetcode.solution.bitmanipulation;

/**
 * 找出无符号整数里的二进制1的个数
 * 如：11 二进制为：00000000000000000000000000001011
 * 1的个数为3
 *
 * @author dadisdad
 * @date 2018/1/22
 */
public class Numberof1Bits {

    /**
     * 把n和1进行与操作，如果是1的话，计数器加1，再将n无符号右移一位，如此循环，知道n=0;
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count = count + (n & 1);
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 优化：利用n&(n-1)
     * n&(n-1)作用：将n的二进制表示中的最低位为1的改为0，先看一个简单的例子:n = 10100(二进制），则(n-1) = 10011 ==》n&(n-1) = 10000
     *
     * @param n
     * @return
     */
    public static int hammingWeightQ(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(3));
        System.out.println(hammingWeight(Integer.MAX_VALUE));
    }
}
