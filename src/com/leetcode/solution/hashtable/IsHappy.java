package com.leetcode.solution.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <pre>
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * </pre>
 *
 * @author dadisdad
 * @date 2018/7/1
 */
public class IsHappy {

    public boolean isHappy(int n) {
        int temp = n;
        Set<Integer> set = new HashSet<>();
        set.add(temp);
        while (true) {
            temp = getNext(temp);
            if (temp == 1) {
                return true;
            } else if (set.contains(temp)) {
                return false;
            }
            set.add(temp);
        }
    }

    private int getNext(int num) {
        int result = 0;
        while (num > 0) {
            result += (num % 10) * (num % 10);
            num = num / 10;
        }
        return result;
    }
}