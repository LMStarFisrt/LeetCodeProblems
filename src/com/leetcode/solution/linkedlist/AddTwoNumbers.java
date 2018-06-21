package com.leetcode.solution.linkedlist;

import com.leetcode.solution.util.ListUtils;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author dadisdad
 * @date 2018/5/3
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pNode = result;
        int carry = 0;
        ListNode temp = null;
        while (l1 != null || l2 != null) {
            temp = new ListNode(0);
            int val = 0;
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                val = l1.val + carry;
                l1 = l1.next;
            } else if (l2 != null) {
                val = l2.val + carry;
                l2 = l2.next;
            }
            carry = val / 10;
            temp.val = val % 10;
            pNode.next = temp;
            pNode = pNode.next;
        }
        if (carry > 0) {
            temp = new ListNode(carry);
            pNode.next = temp;
        }
        return result.next;
    }


    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode ln1 = new ListNode(6);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next = ln3;

        ListNode ln4 = new ListNode(5);
        ListNode ln5 = new ListNode(6);
        ListNode ln6 = new ListNode(4);
        ln4.next = ln5;
        ln5.next = ln6;

        ListUtils.tranverseListNode(solution.addTwoNumbers(ln1, ln4));
    }

}
