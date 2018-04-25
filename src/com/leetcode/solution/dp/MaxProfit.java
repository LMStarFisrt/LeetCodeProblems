package com.leetcode.solution.dp;

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author dadisdad
 * @date 2018/4/25
 */
public class MaxProfit {

    /**
     * 利用动态规划，从前向后遍历数组，记录当前出现过的最低价格，作为买入价格，
     * 并计算以当天价格出售的收益，作为可能的最大收益，
     * 整个遍历过程中，出现过的最大收益就是所求。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }
        int low = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
