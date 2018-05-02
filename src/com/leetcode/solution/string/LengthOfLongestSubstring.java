package com.leetcode.solution.string;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例：
 *
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 *
 * @author dadisdad
 * @date 2018/4/28
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int count = 1;

        int i=0;
        int j=1;
        int length = s.length();

        while (i<length && j<length){
            String substr = s.substring(i,j);
            if(substr.contains(s.subSequence(j,j+1))) {
                i++;
                j=i;
            }
            count = Math.max(j-i+1,count);
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
