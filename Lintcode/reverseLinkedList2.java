package com.company;

// lc 36. Reverse Linked List II

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class reverseLinkedList2 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) { // 1-based, (m - 1)->m->...
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = nNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode; // 3->2; 4->3(->2)
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode; // 2->5(->null)
        premNode.next = nNode; // 1->4(->3->2->5(->null))

        return dummy.next;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode a = new ListNode(1);

        a.next = new ListNode(2);
//        ListNode b = a.next;
//        b.next = new ListNode(3);
        ListNode c = a.next;
        c.next = new ListNode(3);
        c.next.next = new ListNode(4);

        ListNode res = reverseBetween(a, 2, 3);

//        System.out.println(reverseBetween(a, 2, 4)); // com.company.ListNode@4554617c

        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);

    }
}