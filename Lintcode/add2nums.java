package com.company;

// LC 167. Add Two Numbers

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class add2nums {

    public static ListNode addLists(ListNode l1, ListNode l2) {
        // Write your code here

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum = sum / 10;
        }
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(0);
        ListNode newNode = addLists(l1, l2);
        ListNode node = newNode.next.next;
        System.out.print(newNode.val + "->" + newNode.next.val + "->" + node.val + "->" + node.next.val);
    }

}