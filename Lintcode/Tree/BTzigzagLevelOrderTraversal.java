package com.company;

// lc 71.

import java.util.*;

public class Main {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (leftToRight) {
                    list.add(cur.val);
                } else {

                    list.add(0, cur.val);

                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
            
            leftToRight = !leftToRight;
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(zigzagLevelOrder(root));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0, 1);
        list.add(0, 0);
        System.out.println(list); // [0, 1, 2].

    }

}