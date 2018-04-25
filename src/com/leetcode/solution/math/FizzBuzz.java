package com.leetcode.solution.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”
 *
 * @author dadisdad
 * @date 2018/4/25
 */
public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) {
                str += "Fizz";
            }
            if (i % 5 == 0) {
                str += "Buzz";
            }
            if (i % 3 != 0 && i % 5 != 0) {
                str = str + i;
            }
            result.add(str);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fizzBuzz(15).toArray()));
    }
}
