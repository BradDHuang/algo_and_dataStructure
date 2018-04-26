package com.company;

// lc 35.

public class Main {

    public static ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) return null;
        ListNode pre = null;
        while (head != null) {
            // ListNode cur = head;
            ListNode cur = head.next;
            head.next = pre;
            pre = head;
            // head = cur.next;
            head = cur; // form a cycle!
        }
        return pre;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode newHead = reverse(head);
        System.out.println(newHead.val);
        System.out.println(newHead.next.val);
        System.out.println(newHead.next.next);

    }

}