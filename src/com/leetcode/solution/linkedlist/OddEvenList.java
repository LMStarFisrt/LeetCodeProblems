package com.leetcode.solution.linkedlist;

import com.leetcode.solution.util.ListUtils;

/**
 * 奇偶链表
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * @author dadisdad
 * @date 2018/5/3
 */
public class OddEvenList {

    public static ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null && cur.next != null) {
            ListNode temp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = temp;
            cur = cur.next;
            pre = pre.next;
        }

        return head;
    }

    public static ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        //ListUtils.tranverseListNode(oddEvenList1(n1));
        ListUtils.tranverseListNode(oddEvenList2(n1));
    }
}
