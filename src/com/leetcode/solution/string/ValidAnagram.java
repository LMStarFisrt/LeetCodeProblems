package com.leetcode.solution.string;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author dadisdad
 * @date 2018/1/25
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        System.out.println(String.valueOf(sChars));
        System.out.println(String.valueOf(tChars));
        if (Objects.equals(String.valueOf(sChars),String.valueOf(tChars))){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "cat";

        System.out.println(isAnagram(s1,t1));
        System.out.println(isAnagram(s2,t2));
    }

}
