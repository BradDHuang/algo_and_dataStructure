package com.company;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class listNodeBasics {

    public static void print(ListNode node) {
        // write your code here
        while (node != null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // write your code here

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        ListNode head = n1;
        print(head);

        n1 = n2;
        print(n1);
        print(head);
    }

}