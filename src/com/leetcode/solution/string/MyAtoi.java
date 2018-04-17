package com.leetcode.solution.string;

/**
 * 实现 atoi，将字符串转为整数。
 * <p>
 * 在找到第一个非空字符之前，函数需尽可能移除掉空格字符。然后从这个非空字符开始，选取一个可选的正号或负号，并将正号或负号与后面尽可能多的连续的数字组合起来，这部分字符即为数字的值。
 * <p>
 * 字符串可以在形成整数数字的字符后面包括多余的非数字字符，将这些字符忽略，这些对于函数没有影响。
 * <p>
 * 如果字符串中的第一个非空字符不是有效的整数，字符串为空，或字符串仅包含空白字符，则不进行转换。
 * <p>
 * 如果不能执行有效的转换，则返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * <p>
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * <p>
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * <p>
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 *
 * @author dadisdad
 * @date 2018/4/17
 */
public class MyAtoi {

    public static int myAtoi(String str) {
        /**
         * 1、去掉空格；
         */
        str = str.trim();

        /**
         * 2、如果为空，返回0；
         */
        if (str.isEmpty()) {
            return 0;
        }
        int i = 0;
        int ans = 0;        // 结果
        int sign = 1;       // 正负标记，1为正，-1为负
        int len = str.length();
        /**
         * 3、判断第一位是否是+或-
         */
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        for (; i < len; ++i) {
            int tmp = str.charAt(i) - '0';
            /**
             * 不是数字跳出循环；
             */
            if (tmp < 0 || tmp > 9) {
                break;
            }

            /**
             * 巧妙的方法：789=((0+7)*10+8)*10+9
             *
             * 如果tmp是数字，判断当前的结果是否溢出
             */
            if (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                ans = ans * 10 + tmp;
            }
        }
        return sign * ans;

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
