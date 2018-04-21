package com.company;

// lc 94. Binary Tree Maximum Path Sum

public class Main {

    private static int res;
    
    public static int maxPathSum(TreeNode root) {

        // idea: level, btm-up => post-order: left, right, root.
        
        if (root == null) return 0;
//        int res = Integer.MIN_VALUE;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    private static int helper(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(0, helper(root.left)); // there might be negative values.
        int r = Math.max(0, helper(root.right));
        res = Math.max(res, l + r + root.val);
        return root.val + Math.max(l, r);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(7);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(15);
        System.out.println(maxPathSum(root));
//           3
//         /   \
//        7    20
//       / \
//      10 15
    }

}