package com.leetcode.solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个数独是否有效，
 * <p>
 * 数独部分填了数字，空的部分用 '.' 表示。
 * 一个有效的数独（填了一部分的）不一定是可解的，只要已经填的数字是有效的即可。
 *
 * @author dadisdad
 * @date 2018/4/12
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        /**
         * 判断行
         */
        for (int i = 0; i < board.length; i++) {
            if (containsDuplicate(board[i])) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            char[] temp = new char[9];
            char[] temp2 = new char[9];
            for (int j = 0; j < 9; j++) {
                // 列
                temp[j] = board[j][i];
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                // 块
                temp2[j] = board[rowIndex][colIndex];
            }
            if (containsDuplicate(temp)) {
                return false;
            }
            if (containsDuplicate(temp2)) {
                return false;
            }
        }

        return true;
    }

    public boolean containsDuplicate(char[] nums) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else if (nums[i] != '.') {
                map.put(nums[i], i);
            } else {
                continue;
            }
        }
        return false;
    }
}
