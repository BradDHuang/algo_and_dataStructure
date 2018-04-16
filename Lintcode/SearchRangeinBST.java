package com.company;

// lc 11. Search Range in Binary Search Tree

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class SearchRangeinBST {

//    public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
//        // write your code here
//
//        helper(root, k1, k2);
//        return res;
//
//    }
//
//    private static ArrayList<Integer> res = new ArrayList<Integer>();
//
//    private static void helper(TreeNode root, int k1, int k2) {
//        if (root == null) {
//            return;
//        }
//
//        if (root.val > k1) {
//            helper(root.left, k1, k2);
//        }
//
//        if (root.val >= k1 && root.val <= k2) {
//            res.add(root.val);
//        }
//
//        if (root.val < k2) {
//            helper(root.right, k1, k2);
//        }
//    }

    // version 2
    public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here

        List<Integer> res = new ArrayList<>();

        if (root == null) {
//             return null; // NullPointerException
            return res;
        }

        if (root.val <= k2 && root.val >= k1) {
            res.add(root.val);
        }
        List<Integer> left = searchRange(root.left, k1, k2);
        List<Integer> right = searchRange(root.right, k1, k2);
        res.addAll(left);
        res.addAll(right);

        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {
        // write your code here

        TreeNode root = new TreeNode(18);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);

        System.out.println(searchRange(root, 10, 20));

    }
}