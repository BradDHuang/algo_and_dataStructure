package com.company;

// LC 480.
// Binary Tree Paths

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BTPaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        if (root.left == null && root.right == null) {
            // paths.add(root.val);
            paths.add(Integer.toString(root.val));
        }

        List<String> leftpaths = binaryTreePaths(root.left);
        List<String> rightpaths = binaryTreePaths(root.right);

        for (String path : leftpaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightpaths) {
            paths.add(root.val + "->" + path);
        }

        return paths;
    }

    public static void main(String[] args) {
        // write your code here

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode rr = root.left;
        rr.right = new TreeNode(5);
        System.out.print(binaryTreePaths(root));
    }

}