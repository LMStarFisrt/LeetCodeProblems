package com.leetcode.solution.array;

import com.leetcode.solution.util.ArrayUtils;
import com.leetcode.solution.util.CollectionUtils;
import com.leetcode.solution.util.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <pre>
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * </pre>
 * 示例 2:
 * <pre>
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * </pre>
 *
 * @author dadisdad
 * @date 2018/9/3
 */
public class SpiralOrder {

    /**
     * 递归
     * 把数组分解为一个个小螺旋
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (ArrayUtils.isNotEmpty(matrix)) {
            // 行
            int m = matrix.length;
            // 列
            int n = matrix[0].length;
            spiralOrderRec(result, matrix, 0, 0, m, n);
        }
        return result;
    }

    /**
     * @param result 结果
     * @param matrix 数组
     * @param x      x起点
     * @param y      y起点
     * @param m      行
     * @param n      列
     */
    private static void spiralOrderRec(List<Integer> result, int[][] matrix, int x, int y, int m, int n) {
        if (m <= 0 || n <= 0) {
            return;
        }
        if (m == 1 && n == 1) {
            result.add(matrix[x][y]);
            return;
        }
        // 上部 (x,y)->(x,y+n-1)
        for (int i = y; i < y + n; i++) {
            result.add(matrix[x][i]);
        }
        // 右侧 (x+1,y+n-1)->(x+m-2,y+n-1)
        for (int i = x + 1; i < x + m - 1; i++) {
            result.add(matrix[i][y + n - 1]);
        }
        // 底部 (x+m-1,y+n-1)->(x+m-1,y)
        for (int i = y + n - 1, j = x + m - 1; i >= y && j > x; i--) {
            result.add(matrix[x + m - 1][i]);
        }
        // 左侧 (x+m-2,y)->(x+1,y)
        for (int i = x + m - 2, j = y; i > x && j <= y + n - 2; i--) {
            result.add(matrix[i][y]);
        }
        spiralOrderRec(result, matrix, x + 1, y + 1, m - 2, n - 2);
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{1}, {2}, {3}};
        System.out.println(CollectionUtils.List2String(spiralOrder(matrix)));
    }
}
