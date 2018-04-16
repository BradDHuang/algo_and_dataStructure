package com.company;

// lc 106. Convert Sorted List to Balanced BST

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Main {

    private static ListNode curt;

    public static TreeNode sortedListToBST(ListNode head) {
        // write your code here

        int size;
        size = getListLength(head);

        return helper(size);
    }

    private static int getListLength(ListNode head) {

        curt = head;

        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    private static TreeNode helper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = helper(size / 2);
        TreeNode root = new TreeNode(curt.val);
        curt = curt.next;
        TreeNode right = helper(size - 1 - size / 2);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode a = new ListNode(1);

        a.next = new ListNode(5);
//        ListNode b = a.next;
//        b.next = new ListNode(3);
        ListNode c = a.next;
        c.next = new ListNode(10);

        TreeNode res = sortedListToBST(a);

        System.out.println(res.left.val);
        System.out.println(res.val);

        System.out.println(res.right.val);

    }
}