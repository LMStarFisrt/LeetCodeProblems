package com.leetcode.solution.string;

import java.util.Arrays;

/**
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * <p>
 * 示例 1:
 * <pre>
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 说明:
 * </pre>
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 *
 * @author dadisdad
 * @date 2018/6/20
 */
public class ShortestToChar {

    public static int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            String left = S.substring(0, i + 1);
            String right = S.substring(i, len);
            int leftIndex = left.lastIndexOf(C);
            int rightIndex = right.indexOf(C);
            if (leftIndex < 0) {
                result[i] = rightIndex;
            } else {
                if (rightIndex < 0) {
                    result[i] = i - leftIndex;
                } else {
                    result[i] = (i - leftIndex) > rightIndex ? rightIndex : (i - leftIndex);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }
}
