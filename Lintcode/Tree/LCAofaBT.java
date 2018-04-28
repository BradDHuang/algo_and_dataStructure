package com.company;

// lc 88. Lowest Common Ancestor of a Binary Tree

public class Main {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) return root;
        TreeNode l = lowestCommonAncestor(root.left, A, B);
        TreeNode r = lowestCommonAncestor(root.right, A, B);
        if (l != null && r != null) return root;
        if (l != null) return l;
        return r;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        TreeNode res = lowestCommonAncestor(root, root.left, root.left.right);
        System.out.println(res.val);

    }

}