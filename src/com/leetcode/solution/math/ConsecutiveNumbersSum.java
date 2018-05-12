package com.leetcode.solution.math;

/**
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 *
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 *
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 *
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 *
 * @author dadisdad
 * @date 2018/5/12
 */
public class ConsecutiveNumbersSum {

    public static int consecutiveNumbersSum(int N) {
        int line = (int) Math.sqrt(2 * N);
        double tempN = N;
        double i = 1;
        int count = 0;
        while (i <= line) {
            double temp = (2 * N / i + 1 - i) / 2;
            if (temp - (int) temp == 0) {
                count++;
            }
            i += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(3));
    }
}
