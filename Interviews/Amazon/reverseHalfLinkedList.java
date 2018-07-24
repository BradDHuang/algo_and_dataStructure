package com.company;

public class Main {

    public static ListNode reverse(ListNode head) {
        int cnt = 0;
        ListNode cur = head;
        ListNode pre = head;

        ListNode result = head;

        while (cur!= null)// for count how many elements in linked list
        {
            cnt++;
            cur = cur.next;
        }

        for (int i=0; i< (cnt / 2) ; i++)//no matter counter is even or odd, when it divided by 2, the result is even
        {
            pre = head;
            head = head.next;
        }

        ListNode temp;
        ListNode preNext = null;// this variable is used to track the next val behind pre
        // for example, 2->1->3->4->5->6->7->8
        // at this moment, pre:4, start:5
        // I treated 5->6->7->8 as an independent linkedlist
        // I reversed the linkedlist
        // Finally, set the pre node's next value to the reversed linkedlist's head
        // The first half and second half have been connected together

        while (head != null)
        {
            temp = head.next;
            head.next = preNext;
            preNext = head;
            head = temp;
        }
        pre.next = preNext;

        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
//        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node8;

        ListNode res = reverse(node1);

        ListNode node = node1;
        while (node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
    }

}



