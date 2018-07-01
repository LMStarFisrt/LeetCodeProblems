package com.leetcode.solution.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * 示例 :
 * <pre>
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * </pre>
 * 答案: 16
 *
 * @author dadisdad
 * @date 2018/6/19
 */
public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                count++;
                int border = 0;
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    map.put(count, ++border);
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    map.put(count, ++border);
                }
                if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                    map.put(count, ++border);
                }
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    map.put(count, ++border);
                }
            }
        }
        int len = count * 4;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            len = len - entry.getValue();
        }
        return len;
    }

    public static void main(String[] args) {

    }
}