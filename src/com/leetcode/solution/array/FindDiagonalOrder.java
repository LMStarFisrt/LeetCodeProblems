package com.leetcode.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个含有 M x N 个元素的矩阵（M行，N列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * 示例:
 * <pre>
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * </pre>
 *
 * @author dadisdad
 * @data 2018/8/7
 */
public class FindDiagonalOrder {

    public static int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        List<List<Integer>> resList = new ArrayList<>();
        int[] result = new int[m * n];
        for (int i = 0; i < n; i++) {
            int col = i;
            int row = 0;
            List<Integer> tmp = new ArrayList<>();
            while (col >= 0 && col < n && row >= 0 && row < m) {
                tmp.add(matrix[row][col]);
                row++;
                col--;
            }
            if (i % 2 == 0) {
                Collections.reverse(tmp);
            }
            resList.add(tmp);
        }
        for (int j = 1; j < m; j++) {
            int col = n - 1;
            int row = j;
            List<Integer> tmp = new ArrayList<>();
            while (col >= 0 && col < n && row >= 0 && row < m) {
                tmp.add(matrix[row][col]);
                row++;
                col--;
            }
            if ((n + j - 1) % 2 == 0) {
                Collections.reverse(tmp);
            }
            resList.add(tmp);
        }
        int count = 0;
        for (int i = 0; i < resList.size(); i++) {
            List<Integer> integers = resList.get(i);
            for (int j = 0; j < integers.size(); j++) {
                result[count++] = integers.get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
    }
}
