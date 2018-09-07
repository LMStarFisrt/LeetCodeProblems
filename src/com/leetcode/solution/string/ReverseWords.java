package com.leetcode.solution.string;

import java.util.Arrays;

/**
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例:
 * <pre>
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * </pre>
 * 说明:
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author dadisdad
 * @date 2018/9/6
 */
public class ReverseWords {

    public static String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (i != 0) {
                stringBuilder.append(str[i] + " ");
            } else {
                stringBuilder.append(str[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static String reverseWordsII(String s) {
        String[] strs = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            strs[i] = new StringBuilder(strs[i]).reverse().toString();
            if (i != strs.length - 1) {
                stringBuilder.append(strs[i] + " ");
            } else {
                stringBuilder.append(strs[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String aaa = reverseWordsII(s);
        System.out.println(aaa);
    }

}
