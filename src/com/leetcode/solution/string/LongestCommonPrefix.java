package com.leetcode.solution.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在最长公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在最长公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author dadisdad
 * @date 2018/4/17
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        /**
         * 找长度最小的字符串
         */
        String minStr=strs[0];
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<=minStr.length()){
                minStr = strs[i];
            }
        }

        /**
         * 从长度最新字符串最后一位开始对比
         */
        for(int j=minStr.length()-1;j>=0;j--){
            for (int i = 0; i < strs.length; i++) {
                /**
                 * 发现有不一样的，最小字符串将最后一位截掉，
                 */
                if(strs[i].charAt(j)!=minStr.charAt(j)){
                    minStr = minStr.substring(0,j);
                    break;
                }
            }
        }
        return minStr;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aca","cba"}));
    }
}
