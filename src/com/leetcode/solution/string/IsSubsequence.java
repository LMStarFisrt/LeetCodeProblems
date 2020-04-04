package com.leetcode.solution.string;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 *
 * @author 10308
 * @date 2020/4/4
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < sChar.length && j < tChar.length) {
            if (sChar[i] == tChar[j]) {
                i++;
            }
            j++;
        }
        return i == sChar.length;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
