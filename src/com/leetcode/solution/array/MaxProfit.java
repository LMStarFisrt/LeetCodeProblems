package com.leetcode.solution.array;

/**
 * 假设有一个数组，它的第 i 个元素是一个给定的股票在第 i 天的价格。
 * 设计一个算法来找到最大的利润。你可以完成尽可能多的交易（多次买卖股票）。
 * 然而，你不能同时参与多个交易（你必须在再次购买前出售股票）。
 *
 * @author 10308
 * @date 2018/4/9
 */
public class MaxProfit {

    /**
     * 交易的次数不限，实际上是只要有利润就可以买
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int d;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            d = prices[i] - prices[i - 1];
            if (d > 0) {
                max += d;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 5, 6, 3, 7, 8, 9};
        System.out.println(maxProfit(prices));
    }
}
