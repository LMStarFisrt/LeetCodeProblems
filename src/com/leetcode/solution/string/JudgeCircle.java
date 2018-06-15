package com.leetcode.solution.string;

/**
 * 初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，换言之就是判断它是否会移回到原来的位置。
 * <p>
 * 移动顺序由一个字符串表示。每一个动作都是由一个字符来表示的。机器人有效的动作有 R（右），L（左），U（上）和 D（下）。输出应为 true 或 false，表示机器人移动路线是否成圈。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "UD"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "LL"
 * 输出: false
 *
 * @author dadisdad
 * @date 2018/6/15
 */
public class JudgeCircle {

    public static boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        int countR = 0;
        int countU = 0;
        int countL = 0;
        int countD = 0;
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                countR++;
            }
            if (chars[i] == 'L') {
                countL++;
            }
            if (chars[i] == 'U') {
                countU++;
            }
            if (chars[i] == 'D') {
                countD++;
            }
        }

        if (countL == countR && countU == countD) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
    }
}
