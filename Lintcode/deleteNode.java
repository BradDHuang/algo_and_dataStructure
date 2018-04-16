package com.company;

// LC 372. Delete Node in the Middle of Singly Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class Main {

    public static void deleteNode(ListNode node) {
        // write your code here
        if (node == null || node.next == null) {
            return;
        }

        ListNode theNext = node.next;
        node.val = theNext.val;
        node.next = theNext.next;
//        return;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode head = new ListNode(1);
        ListNode a = head.next = new ListNode(2);
        a.next = new ListNode(3);
        a.next.next = new ListNode(4);
        deleteNode(a);
        System.out.println(head.val);
        System.out.println(a.val);
        System.out.println(a.next.val);
    }
}