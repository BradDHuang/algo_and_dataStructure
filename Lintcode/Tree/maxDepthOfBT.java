package com.company;

// lc 97.

import java.util.*;

public class Main {

    public static int maxDepth(TreeNode root) {

        if (root == null) return 0;

        return helper(root, 0);
    }
    private static int helper(TreeNode root, int d) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftD = helper(root.left, d);
        int rightD = helper(root.right, d);
        return Math.max(leftD, rightD) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(maxDepth(root));

    }

}