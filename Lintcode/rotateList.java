package com.company;

// LC 170. Rotate List

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {

    public static ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        int length = 1;
        ListNode dummy = head;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        head.next = dummy;

        // for (int i = 0; i < length - k; i++) {
        for (int i = 0; i < length - k % length; i++) {

            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode head = new ListNode(1);
        ListNode node1 = head.next = new ListNode(3);
        node1.next = new ListNode(5);

        ListNode newHead = rotateRight(head, 8);
        System.out.print(newHead.val + "->");
        System.out.print(newHead.next.val + "->");
        System.out.print(newHead.next.next.val);
    }
}