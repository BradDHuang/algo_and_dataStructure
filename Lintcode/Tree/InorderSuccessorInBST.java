package com.company;

// lc 448.
// It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)

public class Main {

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // Write your code here
        // O(h), where h is the height of the BST.
        if (root == null || p == null) return null;
        if (root.val > p.val) { // 可能root 就是node 的中序后继，也可能是root 左子树中的某个节点
            TreeNode t = inorderSuccessor(root.left, p);
            return t != null ? t : root; // 如果t 为null 则表示左子树中没有满足条件的节点
        }
        else {
            return inorderSuccessor(root.right, p);
        }

//        TreeNode res = null;
//        while (root != null) {
//            if (root.val > p.val) {
//                res = root;
//                root = root.left;
//            } else {
//                root = root.right;
//            }
//        }
//        return res;
    }

//    public static void main(String[] args) {
//        System.out.println();
//    }

}