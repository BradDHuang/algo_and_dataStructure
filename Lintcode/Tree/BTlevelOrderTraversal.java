package com.company;
// lc 69.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// public class TreeNode {
//     TreeNode left, right;
//     int val;
//     TreeNode(int val) {
//         this.val = val;
//         left = right = null;
//     }
// }

public class Main {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        
        // bfs
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode cur = queue.poll();
//                if (cur.left != null) queue.offer(cur.left);
//                if (cur.right != null) queue.offer(cur.right);
//                list.add(cur.val);
//            }
//            res.add(list);
//        }
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
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(levelOrder(root));

    }

}