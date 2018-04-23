package com.company;

// lc 160.

public class Main {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // O(n) time, O(1) memory.
        if (headA == null || headB == null) return null;
//        get use of the Lengths difference!
//        int lenA = len(headA);
//        int lenB = len(headB);
//        if (lenA > lenB) {
//            while (lenA > lenB) {
//                lenA--;
//                headA = headA.next;
//            }
//        } else {
//            while (lenB > lenA) {
//                lenB--;
//                headB = headB.next;
//            }
//        }
//        while (headA != headB) {
//            headA = headA.next;
//            headB = headB.next;
//        }
//        return headA;

        // a ... c ... null -> b ... c;
        // b ... c ... null -> a ... c. ~ O(m + n)
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
//    private static int len(ListNode head) {
//        int len = 0;
//        while (head != null) {
//            len++;
//            head = head.next;
//        }
//        return len;
//    }

    public static void main(String[] args) {

        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(1);
        headB.next = new ListNode(2);
        ListNode c = new ListNode(3);
        c.next = new ListNode(4);
        headA.next = c;
        headB.next.next = c;
        ListNode interSec = getIntersectionNode(headA, headB);
        System.out.println(interSec.val);
        System.out.println(interSec.next.val);
        System.out.println(interSec.next.next);
        
    }

}