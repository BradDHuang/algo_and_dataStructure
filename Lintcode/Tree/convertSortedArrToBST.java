package com.company;

// lc 177.

public class Main {

    public static TreeNode sortedArrayToBST(int[] A) {

        if (A == null || A.length == 0) return null;
        return helper(A, 0, A.length - 1);
    }
    private static TreeNode helper(int[] A, int left, int right) {
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode node = new TreeNode(A[mid]);
        node.left = helper(A, left, mid - 1);
        node.right = helper(A, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {

        int[] A = {1,2,3,4,5,6};
        TreeNode root = sortedArrayToBST(A);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.right.val);
        System.out.println(root.right.left.val);
//           3
//         /   \
//        1     5
//         \   / \
//          2 4   6
        
    }

}