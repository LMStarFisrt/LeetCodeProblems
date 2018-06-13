package com.leetcode.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * @author dadisdad
 * @date 2018/6/13
 */
public class PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        int j = 0;
        while (j <= rowIndex) {
            List<Integer> data = new ArrayList<>();
            for (int i = 0; i <= j; i++) {
                if (i == 0 || i == j) {
                    data.add(1);
                } else {
                    List<Integer> tmp = lists.get(j - 1);
                    data.add(tmp.get(i) + tmp.get(i - 1));
                }
            }
            lists.add(data);
            j++;
        }
        return lists.get(rowIndex);
    }

    public static List<Integer> getRowII(int rowIndex) {
        List<Integer> lists = new ArrayList<>();
        int[] arr = new int[rowIndex + 1];
        int j = 0;
        while (j <= rowIndex) {
            int temp = 0;
            for (int i = 0; i <= j; i++) {
                if (i == 0 || i == j) {
                    arr[i] = 1;
                } else {
                    if (temp == 0) {
                        temp = arr[i];
                        arr[i] = arr[i] + arr[i - 1];
                    } else {
                        int tmp = temp + arr[i];
                        temp = arr[i];
                        arr[i] = tmp;
                    }
                }
            }
            j++;
        }
        for (int i = 0; i < arr.length; i++) {
            lists.add(arr[i]);
        }
        return lists;
    }

    public static List<Integer> getRowIII(int rowIndex) {
        List<Integer> lists = new ArrayList<>();
        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;
        int j = 1;
        while (j <= rowIndex) {
            for (int i = j; i > 0; i--) {
                arr[i] = arr[i] + arr[i - 1];
            }
            j++;
        }
        for (int i = 0; i < arr.length; i++) {
            lists.add(arr[i]);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getRow(6).toArray()));
        System.out.println(Arrays.toString(getRowIII(6).toArray()));
    }
}
