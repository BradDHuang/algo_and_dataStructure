package com.company;

// lc 106.

public class Main {

    public static TreeNode sortedListToBST(ListNode head) {

//        O(N logN)：每层递归一共访问 N/2 个节点，一共 log N 层递归（对应树的高度）。
        if (head == null) return null;
        return helper(head, null);
    }
    private static TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = helper(head, slow);
        node.right = helper(slow.next, tail);
        return node;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        TreeNode root = sortedListToBST(head);
        System.out.println(root.val); // 3
        System.out.println(root.left.val); // 2
        System.out.println(root.right.val); // 4
        System.out.println(root.left.left.val); // 1
//           3
//         /   \
//        2     4
//       /
//      1

    }

}