package com.leetcode.solution.backtracking;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * @author dadisdad
 * @date 2018/5/6
 */
public class Exist {

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从i,j点作为起点开始搜索
                boolean isExisted = search(board, i, j, word, 0);
                if (isExisted) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, int i, int j, String word, int idx) {
        if (idx >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }
        // 将已经搜索过的字母标记一下，防止循环。只要变成另外一个字符，就不会再有循环了。
        board[i][j] ^= 255;
        boolean res = search(board, i - 1, j, word, idx + 1) || search(board, i + 1, j, word, idx + 1) || search(board, i, j - 1, word, idx + 1) || search(board, i, j + 1, word, idx + 1);
        // 再次异或255就能恢复成原来的字母
        board[i][j] ^= 255;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }

}
