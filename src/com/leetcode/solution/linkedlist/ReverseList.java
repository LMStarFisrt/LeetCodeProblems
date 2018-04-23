package com.leetcode.solution.linkedlist;

/**
 * 反转一个单链表。
 * <p>
 * 进阶:
 * 链表可以迭代或递归地反转。你能否两个都实现一遍？
 *
 * @author dadisdad
 * @date 2018/4/23
 */
public class ReverseList {


    public static ListNode reverseList1(ListNode head) {

        ListNode currNode = head;
        ListNode preNode = null;
        ListNode nextNode = null;

        while (currNode != null) {
            ListNode next = currNode.next;
            if (next == null) {
                nextNode = currNode;
            }
            currNode.next = preNode;
            preNode = currNode;
            currNode = next;
        }
        return nextNode;
    }


    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode prev = reverseList2(head.next);
            head.next.next = head; // 节点反转
            head.next = null;
            return prev;
        }

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

        reverseList2(n1);

        ListUtils.tranverseListNode(n5);
    }
}
