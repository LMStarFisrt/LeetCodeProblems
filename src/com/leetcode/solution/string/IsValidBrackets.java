package com.leetcode.solution.string;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @author dadisdad
 * @date 2018/4/26
 */
public class IsValidBrackets {

    public static boolean isValid(String s) {
        Stack<Character> pStack = new Stack<>();
        Stack<Character> needStack = new Stack<>();

        if (s.isEmpty()) {
            return true;
        }

        char[] sChars = s.toCharArray();
        char currentNeed = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != currentNeed) {
                pStack.push(sChars[i]);
                switch (sChars[i]) {
                    case '(':
                        if (currentNeed != 0) {
                            needStack.push(currentNeed);
                        }
                        currentNeed = ')';
                        break;
                    case '[':
                        if (currentNeed != 0) {
                            needStack.push(currentNeed);
                        }
                        currentNeed = ']';
                        break;
                    case '{':
                        if (currentNeed != 0) {
                            needStack.push(currentNeed);
                        }
                        currentNeed = '}';
                        break;
                    default:
                        break;
                }
            } else {
                pStack.pop();
                if (!needStack.isEmpty()) {
                    currentNeed = needStack.pop();
                } else {
                    currentNeed = 0;
                }
            }
        }

        return pStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
