package com.leetcode.solution.linkedlist;

/**
 * @author dadisdad
 * @date 2018/4/23
 */
public class ListUtils {

    /**
     * 遍历链表
     *
     * @param head
     */
    public static void tranverseListNode(ListNode head) {
        for (ListNode x = head; x != null; x = x.next) {
            if (x.next != null) {
                System.out.print(x.val + "->");
            } else {
                System.out.println(x.val);
            }
        }
    }
}
