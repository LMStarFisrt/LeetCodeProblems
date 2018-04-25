package com.leetcode.solution.designproblem;

import java.util.Stack;

/**
 * @author dadisdad
 * @date 2018/4/25
 */
public class MinStack1 {

    private Stack<Integer> data = new Stack<>();

    private Integer min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack1() {
    }

    public void push(int x) {
        if (x <= min) {
            data.push(min);
            min = x;
        }
        data.push(x);
    }

    public void pop() {
        int value = data.pop();
        if (value == min) {
            min = data.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
