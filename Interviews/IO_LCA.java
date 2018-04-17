package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        TreeNode A, B, Root;

        while ((line = in.readLine()) != null) {

            String[] newLine = line.split(" ");

            A = new TreeNode(Integer.valueOf(newLine[0]));
            B = new TreeNode(Integer.valueOf(newLine[1]));

            Root = new TreeNode(30);
            Root.left = new TreeNode(8);
            Root.left.left = new TreeNode(3);
            Root.left.right = new TreeNode(20);
            Root.left.right.left = new TreeNode(10);
            Root.left.right.right = new TreeNode(29);
            Root.right = new TreeNode(52);

            System.out.println(LCA(Root, A, B).val);
        }
    }

    private static TreeNode LCA(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root.val == A.val || root.val == B.val) return root;
        TreeNode left = LCA(root.left, A, B);
        TreeNode right = LCA(root.right, A, B);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }

}