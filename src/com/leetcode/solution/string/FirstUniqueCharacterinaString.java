package com.leetcode.solution.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 假定该字符串只包含小写字母
 *
 * @author dadisdad
 * @date 2017/12/31
 */
public class FirstUniqueCharacterinaString {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar1(s));
        System.out.println(firstUniqChar2(s));
        System.out.println(firstUniqChar3(s));
    }

    /**
     * 通过lastIndexOf和indexOf 寻找比较
     *
     * @param s
     * @return
     */
    public static int firstUniqChar1(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 通过Map
     *
     * @param s
     * @return
     */
    public static int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer value = map.get(chars[i]);
            map.put(chars[i], (value == null ? 0 : value) + 1);

        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 通过数组
     * @param s
     * @return
     */
    public static int firstUniqChar3(String s) {
        char[] chars = s.toCharArray();
        int[] times = new int[26];
        for (int i = 0; i < chars.length; i++) {
            times[chars[i] - 'a']++;

        }
        for (int i = 0; i < chars.length; i++) {
            if (times[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}
