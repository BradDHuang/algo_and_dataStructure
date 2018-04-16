package com.company;

// lc 73. Construct Binary Tree from Preorder and Inorder Traversal

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Main {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (inorder.length != preorder.length) {
            return null;
        }
        return
                myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
                                 int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);

        int position = findPosition(inorder, instart, inend, preorder[prestart]);

        root.left = myBuildTree(inorder, instart, position - 1,
                preorder, prestart + 1, prestart + position - instart);
        root.right = myBuildTree(inorder, position + 1, inend,
                preorder, position - inend + preend + 1, preend);
        return root;
    }

    private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
            // 当我们一找到根节点就跳出，虽然每次查询是线性的，
            // 但是当我们递归调用的时候，我们需要为每个节点寻找对应索引，
            // 那么时间复杂度就变成了n * O(n) = O(n²)
        }
        return -1;
    }

    public static void main(String[] args) {
        // write your code here

        System.out.println();

    }
}

//     比如有前序为[1, 2, 4, 5, 3, 6, 7],中序为[4, 2, 5, 1, 6, 3, 7]
//        也就是这么一颗树
//              1
//            /  \
//          2     3
//         / \   / \
//        4   5 6   7
//        1. 中序的根结点为左右子树的分割点
//        2. 前序的第一个节点为根结点
//        并且这两点对子树也适用，
//        所以我们在递归的时候需要将子树在前序跟中序中的所在区间找出来
//        首先是1为根结点，position = 3那么中序的(instart, position - 1)即(0, 2)=>[4, 2, 5]为左子树所在区间；
//        (position + 1, inend)即(4, 6)=>[6, 3, 7]为右子树区间
//        前序的(prestart + 1, prestart + position - instart)即(1, 3)=>[2, 4, 5]为左子树所在区间,
//        因为中序的(instart, position - 1)为左子树，所以左子树的长度为position - instart,
//        然后在前序中左子树的第一个节点的位置为prestart + 1,因此在前序中的左子树结束位置为prestart + position - instart
//        (position - inend + preend + 1, preend)即(4, 6)=>[3, 6, 7]为右子树区间，
//        这里用position - inend + preend + 1来表示右子树区间的原因是在中序中(position + 1, inend)是右子树，
//        那么右子树的长度为inend - position,而在前序中右子树是一个连续的序列，一直到前序的末尾，
//        所以知道了右子树的长度以后我们可以反着来推右子树的起始位置，也就是preend - (inend - position) + 1