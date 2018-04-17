package com.leetcode.solution.string;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author dadisdad
 * @date 2018/4/17
 */
public class StrStr {

    public static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr2(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        int length1 = haystack.length();
        int length2 = needle.length();
        for (int i = 0; i < length1 - length2 + 1; i++) {
            int count = 0;
            while (count < length2 && haystack.charAt(i + count) == needle.charAt(count)) {
                count++;
            }
            if (count == length2) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr2("hello", "ll"));
        System.out.println(strStr2("aaaaa", "bba"));
    }
}
