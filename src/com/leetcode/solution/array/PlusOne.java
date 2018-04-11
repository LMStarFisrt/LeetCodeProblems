package com.leetcode.solution.array;

import java.util.Arrays;

/**
 * 给定一个非负整数组成的非空数组，给整数加一。
 * <p>
 * 可以假设整数不包含任何前导零，除了数字0本身。
 * <p>
 * 最高位数字存放在列表的首位。
 * <p>
 * 即整数51239组成数组[5,1,2,3,9],加一后为[5,1,2,4,0]
 *
 * @author 10308
 * @date 2018/4/11
 */
public class PlusOne {

    /**
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        for (int i = n; i >= 0; i--) {
            if (digits[i] < 9) {            // 如果小于9，加一
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;      // 等于9，直接置为0
        }
        // 如果循环没有返回，则说明全部为0，新建一个数组将第一位设为1即可
        int[] newDigits = new int[n + 2];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits1 = {5, 1, 2, 3, 9};
        int[] digits2 = {1, 1, 2, 9, 9};
        int[] digits3 = {9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits1)));
        System.out.println(Arrays.toString(plusOne(digits2)));
        System.out.println(Arrays.toString(plusOne(digits3)));
    }
}
