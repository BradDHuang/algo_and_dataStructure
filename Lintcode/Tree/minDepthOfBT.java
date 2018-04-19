package com.company;

// lc 155.

import java.util.*;

public class Main {

    public static int minDepth(TreeNode root) {

    // 当左子树或右子树为空时返回0，为空的时候不能算入深度，
    // 所以应该是left + right + 1.(里面至少有一个0，也就是说，是另一个深度 + 1)
        if (root == null) return 0;
        return helper(root, 0);
    }
    private static int helper(TreeNode root, int d) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftD = helper(root.left, d);
        int rightD = helper(root.right, d);

        if (leftD == 0) leftD = rightD;
        if (rightD == 0) rightD = leftD;

        return Math.min(leftD, rightD) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(6);

        System.out.println(minDepth(root));

    }

}