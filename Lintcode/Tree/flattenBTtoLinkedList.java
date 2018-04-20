package com.company;

// lc 453.

public class Main {

    private static TreeNode lastNode = null;
//    Do it in-place without any extra memory.
    public static void flatten(TreeNode root) {

        // 右，左，根。
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = lastNode;
        root.left = null;
        lastNode = root;
    }

    public static void main(String[] args) {

        System.out.println();
//           1
//         /   \
//        2     5
//       / \     \
//      3   4     6
    }

}