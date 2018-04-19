package com.company;

// lc 70.

import java.util.*;

public class Main {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode cur = queue.poll();
//                list.add(cur.val);
//                if (cur.left != null) queue.offer(cur.left);
//                if (cur.right != null) queue.offer(cur.right);
//            }
//            res.add(list);
//            // res.add(0, list);
//        }
//        Collections.reverse(res);
//        return res;

        // dfs
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }
    private static void helper(List<List<Integer>> res, TreeNode root, int level){
        if (root == null) return;
        if (level == res.size()) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - level - 1).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(levelOrderBottom(root));

    }

}