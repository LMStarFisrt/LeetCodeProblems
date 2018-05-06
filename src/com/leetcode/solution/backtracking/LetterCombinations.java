package com.leetcode.solution.backtracking;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author dadisdad
 * @date 2018/5/6
 */
public class LetterCombinations {

    static String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtracking(digits, result, "", 0);
        return result;
    }

    private static void backtracking(String digits, List<String> result, String tempStr, int start) {
        if (digits.length() == 0) {
            return;
        }
        if (tempStr.length() == digits.length()) {
            result.add(tempStr);
            return;
        }
        int len = letters[(digits.charAt(start) - '0')].length();
        for (int i = 0; i < len; i++) {
            tempStr += letters[digits.charAt(start) - '0'].charAt(i);
            backtracking(digits, result, tempStr, start + 1);
            tempStr = tempStr.substring(0, tempStr.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCombinations("").toArray()));
    }
}
