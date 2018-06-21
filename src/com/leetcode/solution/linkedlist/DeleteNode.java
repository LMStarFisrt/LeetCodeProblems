package com.leetcode.solution.linkedlist;

import com.leetcode.solution.util.ListUtils;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。
 * <p>
 * 比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。
 *
 * @author dadisdad
 * @date 2018/4/18
 */
public class DeleteNode {

    /**
     * 解法就是将当前节点设为下一个节点
     *
     * @param node
     */
    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next = null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        deleteNode(n3);

        ListUtils.tranverseListNode(n1);
    }
}
