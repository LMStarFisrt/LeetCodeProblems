package com.leetcode.solution.string;

/**
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1 <br>
 * 2.     11<br>
 * 3.     21<br>
 * 4.     1211<br>
 * 5.     111221<br>
 * 1 被读作  "one 1"  ("一个一") , 即 11。<br>
 * 11 被读作 "two 1s" ("两个一"）, 即 21。<br>
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。<br>
 * <p>
 * 给定一个正整数 n ，输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 *
 * @author dadisdad
 * @date 2018/4/17
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1";
        while (--n > 0) {
            int length = result.length();
            String temp = "";
            for (int i = 0; i < length; i++) {
                int count = 1;
                while (i + 1 < length && result.charAt(i) == result.charAt(i + 1)) {
                    count++;
                    i++;
                }
                temp = temp + count + result.charAt(i);
            }
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

}
