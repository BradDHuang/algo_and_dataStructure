package com.company;

// lc 96. Partition List

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {

    public static ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode d1 = dummy1, d2 = dummy2; // d1, d2 are created for updating.

        while (head != null) {
            if (head.val < x) {
                d1.next = head;

                d1 = head; // update

            } else {
                d2.next = head;

                d2 = head;

            }
            head = head.next;
        }

        d2.next = null;
        // d1.next = dummy2;
        d1.next = dummy2.next;

        return dummy1.next;
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

        ListNode res = partition(a, 4);

//        System.out.println(reverseBetween(a, 2, 4)); // com.company.ListNode@4554617c

        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);

    }
}