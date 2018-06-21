package com.leetcode.solution.linkedlist;

import com.leetcode.solution.util.ListUtils;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author dadisdad
 * @date 2018/4/18
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        int count = 0;
        /**
         * 第一次遍历计数
         */
        for (ListNode x = head; x != null; x = x.next) {
            count++;
        }
        ListNode node = head;
        /**
         * 遍历完成之后 node 为 倒数n+1个节点
         */
        for (int i = 0; i < count - n - 1; i++) {
            node = node.next;
        }
        /**
         * 删除头部
         */
        if (n == count) {
            head = node.next;
        } else if (n == 1) {
            /**
             * 删除尾部
             */
            node.next = null;
        } else {
            node.next = node.next.next;
        }
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        /**
         * 定义一个temp节点
         */
        ListNode temp = null;
        ListNode endNode = head;
        while (endNode != null) {
            endNode = endNode.next;
            /**
             * endNode 节点先移动n步；
             * 这样head和temp之间差n个节点
             * 之后head和temp一起往后移动，
             * 当head移动到了NULL的时候，
             * temp移动到了倒数第n+1个节点的位置，
             * 之时候改变temp->next将他指向他的下一个节点的下一个节点，这样就是把倒数第n个节点给删掉了
             */
            if (n > 0) {
                n--;
            } else {
                if (temp == null) {
                    temp = head;
                } else {
                    temp = temp.next;
                }
            }
        }
        if (temp == null) {
            return head.next;
        } else {
            temp.next = temp.next.next;
            return head;
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

        ListUtils.tranverseListNode(removeNthFromEnd2(n1, 1));
    }
}
