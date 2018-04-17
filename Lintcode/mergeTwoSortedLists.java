package com.company;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class mergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here

        // 此处我们用recursion 解法
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode newHead;
        if (l1.val < l2.val) {
            newHead = l1;
            newHead.next = mergeTwoLists(l1.next, l2);
        } else {
            newHead = l2;
            newHead.next = mergeTwoLists(l1, l2.next);
        }
        return newHead;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        a.next = new ListNode(2);
//        b.next = new ListNode(1);


        ListNode c = mergeTwoLists(a, b);
        System.out.println(c.val);
        System.out.println(c.next.val);
        System.out.println(c.next.next.val);

    }

}