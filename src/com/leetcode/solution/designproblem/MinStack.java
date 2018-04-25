package com.leetcode.solution.designproblem;

import java.util.Stack;

/**
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
