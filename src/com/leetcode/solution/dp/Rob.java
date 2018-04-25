package com.leetcode.solution.dp;

/**
 * 打家劫舍
 * 你是一个专业的强盗，计划抢劫沿街的房屋。每间房都藏有一定的现金，阻止你抢劫他们的唯一的制约因素就是相邻的房屋有保安系统连接，如果两间相邻的房屋在同一晚上被闯入，它会自动联系警方。
 * <p>
 * 给定一个代表每个房屋的金额的非负整数列表，确定你可以在没有提醒警方的情况下抢劫的最高金额。
 *
 * @author dadisdad
 * @date 2018/4/25
 */
public class Rob {

    public static int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[n - 1];
        }
        int m1 = nums[0];
        int m2 = nums[1];
        int max = Math.max(m1, m2);
        int thisMax1 = 0;
        int thisMax2 = max;
        for (int i = 2; i < n; i++) {
            if (i == 2) {
                thisMax1 = max;
                max = Math.max(nums[i - 2] + nums[i], max);
                thisMax2 = max;
            } else {
                int temp = max;
                max = Math.max(thisMax1 + nums[i], thisMax2);
                thisMax1 = temp;
                thisMax2 = max;
            }
        }
        return max;
    }

    public static int rob2(int[] nums) {
        /**
         * 表示选择
         *
         */
        int rob = 0;

        /**
         * 表示放弃
         *
         */
        int giveup = 0;

        for (int n : nums) {
            /**
             * 选择了当前house，值为上次放弃的加上当前house的money
             */
            int robi = giveup + n;

            /**
             * 没有选择当前houses，那么它等于上次选择了或没选择的最大值
             */
            int giveupi = Math.max(rob, giveup);

            rob = robi;
            giveup = giveupi;
        }
        return Math.max(rob, giveup);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 8, 3, 4, 5, 6};
        int[] nums2 = {3, 1, 0, 5};
        System.out.println(rob1(nums1));
        System.out.println(rob1(nums2));

        System.out.println(rob2(nums1));
        System.out.println(rob2(nums2));
    }
}
