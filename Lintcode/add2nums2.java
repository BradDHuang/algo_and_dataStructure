package com.company;

//LC 221. Add Two Numbers II

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class add2numsII {

    public static ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode cur = new ListNode(0);
        int sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {

            // int sum = 0;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            cur.val = sum % 10;
            ListNode head = new ListNode(sum/10);
            head.next = cur;
            cur = head;
            sum = sum/10;
        }
        return cur.val == 0 ? cur.next : cur;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(6);
        h1.next = new ListNode(1);
        h1.next.next = new ListNode(7);
        ListNode h2 = new ListNode(2);
        h2.next = new ListNode(9);
        h2.next.next = new ListNode(5);

        ListNode h3 = addLists2(h1, h2);
        while (h3.next != null) {
            System.out.print(h3.val + "->");
            h3 = h3.next;
        }
        System.out.print(h3.val);
    }
}