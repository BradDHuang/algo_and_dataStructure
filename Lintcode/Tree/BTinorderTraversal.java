package com.company;
// lc 67.
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// public class TreeNode {
//     TreeNode left, right;
//     int val;
//     TreeNode(int val) {
//         this.val = val;
//         left = right = null;
//     }
// }

public class Main {

    public static List<Integer> inorderTraversal(TreeNode root) {

        //        List<Integer> res = new ArrayList<>();
//        if (root == null) return res;
//        res.addAll(inorderTraversal(root.left));
//        res.add(root.val);
//        res.addAll(inorderTraversal(root.right));
//        return res;

        // non-recursion, Stack.
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal(root));

    }

}