package com.company;

// LC 511. Swap Two Nodes in Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {

    public static ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode pre1 = null, pre2 = null;
        while (head.next != null) {
            if (head.next.val == v1) {
                pre1 = head;
            }
            if (head.next.val == v2) {
                pre2 = head;
            }

            head = head.next;

        }
        if (pre1 == null || pre2 == null) {
            return dummy.next;
        }

        ListNode n1 = pre1.next, n2 = pre2.next;
        ListNode n1Next = n1.next, n2Next = n2.next;
        // 因为Swap 两个Node，我们必须要分别找到这个两个Node的前一个节点，然后进行交换处理，
        // 如果其中一个恰好是另一个的前一个，那么交换操作就会出现问题
        if (n1 == pre2) { // n1 -> n2
            pre1.next = n2;
            n2.next = n1;
            n1.next = n2Next;
        } else if (n2 == pre1) {
            pre2.next = n1;
            n1.next = n2;
            n2.next = n1Next;
        } else {
            pre1.next = n2;
            n2.next = n1Next;
            pre2.next = n1;
            n1.next = n2Next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode head = new ListNode(3);
        ListNode node1 = head.next = new ListNode(5);
        node1.next = new ListNode(7);
//        head.next.next = null;
        ListNode newHead = swapNodes(head, 3, 7);
        System.out.print(newHead.val + "->");
        System.out.print(newHead.next.val + "->");
        System.out.print(newHead.next.next.val);
    }
}