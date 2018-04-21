package com.company;

// lc 68.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

//    static List<Integer> res;
//    public static List<Integer> postorderTraversal(TreeNode root) {
//        res = new ArrayList<>();
//        if (root == null) return res;
//        helper(root);
//        return res;
//    }
//    private static void helper(TreeNode root) {
//        if (root == null) return;
//        helper(root.left);
//        helper(root.right);
//        res.add(root.val);
//    }

    // without recursion. use Stack!
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            // res.add(0, cur.val);
//            res.addFirst(cur.val);
            res.add(cur.val);
            
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        
        Collections.reverse(res);
        
        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(root));
        
    }

}