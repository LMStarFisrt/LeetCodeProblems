package com.leetcode.solution.array;

import java.util.*;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * @author dadisdad
 * @date 2018/4/27
 */
public class SetZeroes {

    /**
     * 空间复杂度O(mn)
     * 时间复杂度O(n^3)
     *
     * @param matrix
     */
    public static void setZeroes1(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (temp[i][j] == 0) {

                    for (int l = 0; l < matrix[i].length; l++) {
                        matrix[i][l] = 0;
                    }

                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }

    }

    /**
     * 空间复杂度O(m+n)
     * 时间复杂度O(n^2)
     *
     * @param matrix
     */
    public static void setZeroes2(int[][] matrix) {

        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }
        xs.forEach(integer -> {
            for (int l = 0; l < matrix[integer].length; l++) {
                matrix[integer][l] = 0;
            }
        });

        ys.forEach(integer -> {
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][integer] = 0;
            }
        });

    }

    /**
     * 常数空间
     * 时间复杂度O(n^2)
     *
     * @param matrix
     */
    public static void setZeroes3(int[][] matrix) {
        boolean firstZero = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstZero = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (firstZero) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix2 = {
                {3, 1, 2, 0},
                {0, 4, 5, 2},
                {1, 3, 1, 5}
        };

        //setZeroes1(matrix1);
        //setZeroes1(matrix2);
        //setZeroes2(matrix1);
        //setZeroes2(matrix2);
        setZeroes3(matrix1);
        setZeroes3(matrix2);
        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
    }
}
