package com.leetcode.solution.linkedlist;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 进阶：
 * 你能否不使用额外空间解决此题？
 *
 * @author dadisdad
 * @date 2018/4/23
 */
public class HasCycle {

    /**
     * 快慢指针判断，如果存在环，则两者一定会相遇，不存在，fast遇到null 就退出
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
