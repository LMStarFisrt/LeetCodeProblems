package com.leetcode.solution.linkedlist;


import com.leetcode.solution.util.ListUtils;

/**
 * 合并两个有序链表
 *
 * @author dadisdad
 * @date 2018/1/24
 */
public class MergeTwoSortedLists {

    /**
     * 非递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode prev = result;
        while (l2 != null && l1 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return result.next;
    }

    /**
     * 采用递归方法
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;

        //ListUtils.tranverseListNode(mergeTwoLists1(n1,n4));
        ListUtils.tranverseListNode(mergeTwoLists2(n1,n4));
    }

}