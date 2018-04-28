package com.company;

// lc 223.

public class Main {

    public static boolean isPalindrome(ListNode head) {
        // write your code here
        // in O(n) time & O(1) space.

        if (head == null) return true;

//        ListNode p = head;
        ListNode mid = middle(head);
        ListNode re = reverse(mid.next);
//        ListNode q = re;

        while (head != null && re != null) {
            if (head.val != re.val) {
                return false;
            }
            re = re.next;
            head = head.next;
        }
        return true;
    }
    private static ListNode middle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) { // reverse list.
            ListNode cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

    }

}