package com.company;

// LC 155.
// Minimum Depth of Binary Tree

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class minDepthOfBT {

    public static int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // if (left == 0 && right == 0) {
        //     return 1;
        // } else
        if (left == 0) {
            left = right; // {1,#,2,3}, minDepth is 3.
            // 当左子树或右子树为空时返回0，为空的时候不能算入深度，
            // 所以应该是left + right + 1
            // (里面至少有一个0，也就是说，是另一个深度+1)
        } else if (right == 0) {
            right = left;
        }

        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        // write your code here

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(1);
        TreeNode rr = root.right;
        rr.left = new TreeNode(1);
        System.out.print(minDepth(root));
    }

}