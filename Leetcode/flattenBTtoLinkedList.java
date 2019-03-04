package com.company;

//import java.util.*;

// import java.util.LinkedList;
// import java.util.List;
import java.util.Stack;

//public class TreeNode {
//    int val;
//    TreeNode left, right;
//    TreeNode(int val) {
//        this.val = val;
//        this.left = null;
//        this.right = null;
//    }
//}

public class Main {

    static TreeNode lastvisited = null;
    public static void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode realright = root.right;
        if(lastvisited != null) {
            lastvisited.left = null;
            lastvisited.right = root;
        }
        lastvisited = root;
        flatten(root.left);
        flatten(realright);
    }
    
    // Solution with Stack
    public static void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !stack.empty()) {
            if(p.right != null) {
                stack.push(p.right);
            }
            if(p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if(!stack.empty()) {
                p.right = stack.pop();
            }
            p = p.right;
        }
    }
    
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        System.out.println(root.right.right.right.val); // 4
    }

}


