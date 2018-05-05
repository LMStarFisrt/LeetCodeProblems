package com.leetcode.solution.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * @author dadisdad
 * @date 2018/5/5
 */
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String temp = "";
        backtracking(n,result,temp,0,0);
        return result;
    }

    private static void backtracking(int n, List<String> result, String temp, int left, int right) {
        if (left>n || right>n|| left<right){
            return;
        }
        if (left==n && right==n){
            result.add(temp);
        }else {
            backtracking(n,result,temp+"(",left+1,right);
            backtracking(n,result,temp+")",left,right+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateParenthesis(4).toArray()));
    }
}
