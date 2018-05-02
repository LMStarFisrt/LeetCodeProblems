package com.leetcode.solution.string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author dadisdad
 * @date 2018/5/2
 */
public class LongestPalindrome {

    /**
     * 暴力法。从最长字串开始判断所有字串是否是回文
     *
     * O(n^3)
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        int length = s.length();
        for (int size = s.length(); size > 0; size--) {
            for (int low = 0, high = low + size - 1; high < length; low++, high++) {
                if (isPalindrom(s, low, high)) {
                    return s.substring(low, high + 1);
                }
            }
        }
        return s.substring(0, 1);
    }


    private static boolean isPalindrom(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static int max = 0;
    private static String res = "";

    /**
     * 从中心点向外扩散，复杂度O(n^2)
     * 从字符的中心开始，向两边扩散检查回文。这需要维护一个指针，从头开始，以每一个位置为中心遍历一遍。
     * 以某个字符为核心一旦探测到边界，更长的的串就都不再考虑。
     * 注意，回文需要同时检查单核`aba`以及双核`abba`的情况。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        for (int i = 0; i < length; i++) {
            checkPalindromeExpand(s, i, i);
            checkPalindromeExpand(s, i, i + 1);
        }
        return res;
    }

    private static void checkPalindromeExpand(String s, int low, int high) {
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > max) {
                    max = high - low + 1;
                    res = s.substring(low, high + 1);
                }
                low--;
                high++;
            } else {
                break;
            }
        }
    }

    private static int[] p;
    private static String s;
    private static char[] t;

    /**
     * Manacher算法，复杂度O(n)
     *
     * @param str
     * @return
     */
    public static String longestPalindrome3(String str) {
        s = str;
        preprocess();
        p = new int[t.length];
        int mid = 0, right = 0;
        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * mid - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                mid = i;
                right = i + p[i];
            }
        }

        int length = 0;
        int center = 0;
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    private static void preprocess() {
        t = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[s.length() * 2 + 1] = '#';
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("babad"));
        System.out.println(longestPalindrome1("cbbd"));

        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome2("cbbd"));

        System.out.println(longestPalindrome3("babad"));
        System.out.println(longestPalindrome3("cbbd"));
    }
}
