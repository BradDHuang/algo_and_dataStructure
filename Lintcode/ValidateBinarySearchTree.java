package com.company;

// ***
// LC 95.
// Validate Binary Search Tree
// ***

// import javax.swing.tree.TreeNode;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
        this.left = this.right = null;
    }
}

public class ValidateBinarySearchTree {

    private static boolean firstNode = true;
    private static int lastVal = Integer.MIN_VALUE;

    public static boolean isValidBST(TreeNode root){
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }

        firstNode = false;
        lastVal = root.val;

        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // write your code here
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        System.out.println(isValidBST(root));
    }

}