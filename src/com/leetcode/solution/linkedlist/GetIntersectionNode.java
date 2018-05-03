package com.leetcode.solution.linkedlist;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 *
 *
 * 例如，下面的两个链表：
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * 在节点 c1 开始相交。
 *
 *
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author dadisdad
 * @date 2018/5/3
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode result = null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        int len1 = 0;
        int len2 = 0;
        while (tempA != null) {
            len1++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            len2++;
            tempB = tempB.next;
        }
        if (len1 > len2) {
            int a = len1 - len2;
            while (a > 0) {
                headA = headA.next;
                a--;
            }
        } else {
            int a = len2 - len1;
            while (a > 0) {
                headB = headB.next;
                a--;
            }
        }
        while (headA != null && headB != null) {
            if (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            } else {
                result = headA;
                break;
            }
        }
        return result;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        if (null == headA || null == headB) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        //如果ab长度一样，一次循环迭代就可以找出
        //如果ab长度不一样，另两个引用指向另一方，根据lenA + lenB = lenB + lenA
        //那么第二次循环的时候，两个链表剩余的长度就是一样的了。
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }


    public static void main(String[] args) {
        GetIntersectionNode solution = new GetIntersectionNode();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(8);

        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        System.out.println(solution.getIntersectionNode(a1, b1).val);
    }


}
