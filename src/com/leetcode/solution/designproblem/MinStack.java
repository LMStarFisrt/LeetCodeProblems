package com.leetcode.solution.designproblem;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素x推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author dadisdad
 * @date 2018/4/25
 */
public class MinStack {

    private Stack<Integer> data = new Stack<>();

    private Stack<Integer> min = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        data.push(x);
        if (min.empty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        int value = data.pop();
        if (value == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
