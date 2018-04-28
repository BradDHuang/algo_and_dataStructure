package com.company;

// lc 902.
// 前k 个点每个点上的处理时间为O(1). 所以，总共处理时间为O(k),
// 另外, 找到第一个点最坏需要O(h) 的时间，所以一共是O(k + h).

public class Main {

    private static int res, count;
    
    public static int kthSmallest(TreeNode root, int k) {
        // write your code here
        count = k;
        helper(root);
        return res;
    }
    private static void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) res = root.val;
        helper(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        System.out.println(kthSmallest(root, 4));

    }

}