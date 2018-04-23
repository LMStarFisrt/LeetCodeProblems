package com.leetcode.solution.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请检查一个链表是否为回文链表。
 * <p>
 * 进阶：
 * 你能在 O(n) 的时间和 O(1) 的额外空间中做到吗？
 *
 * @author dadisdad
 * @date 2018/4/23
 */
public class IsPalindrome {

    /**
     * 将链表元素放置到list中，判断list是否回文
     * 空间复杂度O(n) 时间复杂度O(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode x = head; x != null; x = x.next) {
            list.add(x.val);
        }
        int i = 0;
        int j = list.size() - 1;
        while (i != j && i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {

        if (head == null) {
            return true;
        }
        /**
         * 用快慢指针获取中间节点
         */
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        /**
         * 后半段的链表翻转
         */
        ListNode last = slow.next;
        ListNode pre = head;
        while (last != null && last.next != null) {
            ListNode temp = last.next;
            last.next = temp.next;
            temp.next = slow.next;
            slow.next = temp;
        }
        while (slow.next != null) {
            slow = slow.next;
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);

        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(6);
        ListNode n8 = new ListNode(2);
        ListNode n9 = new ListNode(4);
        ListNode n10 = new ListNode(8);
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        System.out.println(isPalindrome1(n1));
        System.out.println(isPalindrome1(n4));
        System.out.println(isPalindrome1(n5));

        //System.out.println(isPalindrome2(n1));
        //System.out.println(isPalindrome2(n4));
        System.out.println(isPalindrome2(n5));
    }
}
