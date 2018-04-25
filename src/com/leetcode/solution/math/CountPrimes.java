package com.leetcode.solution.math;

import java.util.Arrays;

/**
 * 计算所有小于非负数整数 n 的质数数量。
 *
 * @author dadisdad
 * @date 2018/4/25
 */
public class CountPrimes {

    /**
     * 从2开始遍历到根号n，先找到第一个质数2，然后将其所有的倍数全部标记出来，
     * 然后到下一个质数3，标记其所有倍数，一次类推，直到根号n，此时数组中未被标记的数字就是质数。
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!primes[i]) {
                continue;
            }
            for (int j = i * i; j < n; j = j + i) {
                primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrimes(int n) {
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(5));
    }
}
