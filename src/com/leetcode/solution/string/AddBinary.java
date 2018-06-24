package com.leetcode.solution.string;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <pre>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * </pre>
 * 示例 2:
 * <pre>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * </pre>
 *
 * @author dadisdad
 * @date 2018/6/24
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        StringBuilder res = new StringBuilder();
        char carry = '0';
        int i = aChars.length - 1;
        int j = bChars.length - 1;
        while (i >= 0 && j >= 0) {
            int tmp = (aChars[i] ^ bChars[j]);
            tmp = tmp ^ (carry - '0');
            res = res.append(tmp);
            if ((aChars[i] == '1' && bChars[j] == '1') || (carry == '1' && (aChars[i] == '1' || bChars[j] == '1'))) {
                carry = '1';
            } else {
                carry = '0';
            }
            i--;
            j--;
        }
        while (i >= 0) {
            int tmp = aChars[i] ^ carry;
            res = res.append(tmp);
            if ((aChars[i] == '1') && (carry == '1')) {
                carry = '1';
            } else {
                carry = '0';
            }
            i--;
        }
        while (j >= 0) {
            int tmp = bChars[j] ^ carry;
            res = res.append(tmp);
            if ((bChars[j] == '1') && carry == '1') {
                carry = '1';
            } else {
                carry = '0';
            }
            j--;
        }
        if (carry == '1') {
            res = res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("110010", "10111"));
    }

}
