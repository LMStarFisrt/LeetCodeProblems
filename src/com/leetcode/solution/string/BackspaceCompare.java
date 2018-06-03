package com.leetcode.solution.string;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 * @author dadisdad
 * @date 2018/6/3
 */
public class BackspaceCompare {

    public static boolean backspaceCompare(String S, String T) {
        if (S.isEmpty() && T.isEmpty()) {
            return true;
        }
        if (S == null && T == null) {
            return true;
        }
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();

        push(sStack, sChars);
        push(tStack, tChars);
        if (sStack.size() != tStack.size()) {
            return false;
        } else {
            while (!sStack.isEmpty() && !tStack.isEmpty()) {
                if (!sStack.pop().equals(tStack.pop())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void push(Stack<Character> stack, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
            if (chars[i] == '#') {
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));
    }
}
