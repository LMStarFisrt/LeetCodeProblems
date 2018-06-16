package com.leetcode.solution.math;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 * 注意:
 * <p>
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * 示例 2:
 * <p>
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 *
 * @author dadisdad
 * @date 2018/6/16
 */
public class FindComplement {

    public static int findComplement(int num) {
        int count = 0;
        int res = 0;
        while (num > 0) {
            int a = num % 2;
            num = num / 2;
            res = res + (a == 1 ? 0 : (int) Math.pow(2, count));
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }
}
