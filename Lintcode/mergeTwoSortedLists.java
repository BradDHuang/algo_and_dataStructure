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


// alt
package com.company;

//import java.util.*;

// leetcode 21. merge 2 sorted lists

import java.util.LinkedList;
import java.util.List;

/*
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
*/
public class Main {

    // Merge two sorted linked lists and return it as a new list.
    // The new list should be made by splicing together the nodes of the first two lists.

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
//            Input: 1->2->4, 1->3->4
//            Output: 1->1->2->3->4->4
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
        }
        cur.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = mergeTwoSortedLists(l1, l2);
        while (res.next != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        if (res.next == null) {
            System.out.println(res.val);
        }
        // 1->1->2->3->4->4
    }

}





