package com.leetcode.solution.string;

/**
 * 给定一个字符串，确定它是否是回文，只考虑字母数字字符和忽略大小写。
 * <p>
 * 例如：
 * "A man, a plan, a canal: Panama" 是回文字符串。
 * "race a car" 不是回文字符串。
 * <p>
 * 注意:
 * 你有考虑过这个字符串可能是空的吗？ 在面试中这是一个很好的问题。
 * <p>
 * 针对此题目，我们将空字符串定义为有效的回文字符串。
 *
 * @author dadisdad
 * @date 2018/4/17
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.length() == 0) {
            return true;
        }
        char[] chars = new char[s.length()];
        int count = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            char sChar = sChars[i];
            if ((sChar >= 48 && sChar <= 57) || (sChar >= 97 && sChar <= 122)) {
                chars[count] = sChar;
                count++;
            }
        }
        for (int i = 0; i < count / 2; i++) {
            if (chars[i] != chars[count - 1 - i]) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("    "));
    }

}
