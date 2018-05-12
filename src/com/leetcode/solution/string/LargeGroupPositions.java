package com.leetcode.solution.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *
 * @author dadisdad
 * @date 2018/5/12
 */
public class LargeGroupPositions {

    public static List<List<Integer>> largeGroupPositions(String str) {
        List<List<Integer>> result = new ArrayList<>();
        if (str.length() == 0 || str == null) {
            return result;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] != temp) {
                    if (j - i >= 3) {
                        List<Integer> data = new ArrayList<>();
                        data.add(i);
                        data.add(j - 1);
                        result.add(data);
                    }
                    i = j - 1;
                    break;
                } else {
                    if (chars[j] == temp && j == chars.length - 1 && j - i >= 2) {
                        List<Integer> data = new ArrayList<>();
                        data.add(i);
                        data.add(j);
                        result.add(data);
                        i = j;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(largeGroupPositions("aaaa").toArray()));
    }
}
