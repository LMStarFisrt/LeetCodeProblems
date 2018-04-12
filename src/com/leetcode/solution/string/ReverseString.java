package com.leetcode.solution.string;

import java.util.Arrays;

/**
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 * <p>
 * 示例：
 * <p>
 * 输入：s = "hello"
 * 返回："olleh"
 *
 * @author dadisdad
 * @date 2018/4/12
 */
public class ReverseString {

    /**
     * 向后遍历
     *
     * @param s
     * @return
     */
    public static String reverseString1(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            builder = builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    /**
     * 双指针首尾交换
     *
     * @param s
     * @return
     */
    public static String reverseString2(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "hdasdellodsad";
        System.out.println(reverseString1(s));
        System.out.println(reverseString2(s));
    }
}
