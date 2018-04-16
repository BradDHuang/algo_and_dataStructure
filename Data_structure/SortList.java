package com.company;

// lc 98. Sort List

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {

    public static ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);

        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        // 快、慢指针：快指针到达end 的时候，慢指针刚好到达mid.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        if (node1 != null) {
            tail.next = node1;
        } else {
            tail.next = node2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode a = new ListNode(1);

        a.next = new ListNode(4);
//        ListNode b = a.next;
//        b.next = new ListNode(3);
        ListNode c = a.next;
        c.next = new ListNode(3);
        c.next.next = new ListNode(5);

        ListNode res = sortList(a);

//        System.out.println(reverseBetween(a, 2, 4)); // com.company.ListNode@4554617c

        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);

    }
}