package com.leetcode.solution.array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像旋转 90 度（顺时针）。
 * <p>
 * 注意：
 * <p>
 * 你必须在原矩阵中旋转图像，请不要使用另一个矩阵来旋转图像。
 * <p>
 * 例 1:
 * <p>
 * 给出的输入矩阵 =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 旋转输入矩阵，使其变为 :
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * <p>
 * 例 2:
 * <p>
 * 给出的输入矩阵 =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 旋转输入矩阵，使其变为 :
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author dadisdad
 * @date 2018/4/12
 */
public class Rotate {

    /**
     * 先以 / 方向对称轴翻转，在上下翻转
     *
     * @param matrix
     */
    public static void rotate1(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < matrix[i].length - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][length - 1 - i];
                matrix[length - 1 - j][length - 1 - i] = temp;
            }
        }
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = temp;
            }
        }
    }

    /**
     * 先以 \ 方向对称轴翻转，在左右翻转
     *
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - 1 - j] = temp;
            }
        }
    }
}
