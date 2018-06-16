package com.leetcode.solution.math;

import com.leetcode.solution.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * <p>
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * <p>
 * 还有，自除数不允许包含 0 。
 * <p>
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 * <p>
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 *
 * @author dadisdad
 * @date 2018/6/16
 */
public class SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDividingNumbers(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean isDividingNumbers(int num) {
        int tmp = num;
        while (tmp > 0) {
            int a = tmp % 10;
            if (a == 0) {
                return false;
            }
            int res = num % a;
            if (res != 0) {
                return false;
            }
            tmp = tmp / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CollectionUtils.List2String(selfDividingNumbers(1, 22)));
    }
}
