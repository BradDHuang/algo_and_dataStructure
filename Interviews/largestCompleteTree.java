package com.company;

class TreeNode {
    private int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class largestCompleteTree {

    public static int largestCompleteTree(TreeNode root){

        int[] ans = new int[]{0};
        // 直接用 int ans = 0; 的话，ans 本身可能不变，只是ans 的copy 的值变了！
        // 函数的参数传递是：copy value！

//        ans[0] = largestCompleteTree(root, ans);
        largestCompleteTree(root, ans);

//        if (ans[0] >= 1)
        return (1 << ans[0]) - 1; // ans: 0; 1, 1 + 2, 1 + 2 + 4, ...
//        return -1;
    }

    public static int largestCompleteTree(TreeNode root, int[] ans){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int l = largestCompleteTree(root.left, ans);
        int r = largestCompleteTree(root.right, ans);
        ans[0] = Math.max(ans[0], Math.min(l, r) + 1);
        return Math.min(l, r) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.left = new TreeNode(5);
        System.out.println(largestCompleteTree(root));

        int age = 18;
        String str = "I am " + age + 1 + " years old"; // 181
//        String str = "I am " + (age + 1) + " years old"; // 19
        System.out.println(str);

        int i = 0;
        System.out.println(inc(i)); // copy value i = 1;
        System.out.println((i)); // i（本身） = 0;

        int[] j = {0};
        System.out.println(inc(j)); // j[0] = 1;
        System.out.println((j[0])); // j[0] = 1; // 因为j[0]指向的对象的值被改变了！

        String student1 = new String("Jack");
        String student2 = new String("Rose");
        student1 = student2;
        System.out.println(student1); // Rose

    }
    private static int inc(int i) {
        i = i + 1;
        return i;
    }
    private static int inc(int[] j) {
        j[0] = j[0] + 1;
        return j[0];
    }

}