package com.company;

// lc 840. Range Sum Query - Mutable
// Binary Index Tree!

public class NumArray {

    private static int[] tree;
    private static int[] nums;
    public NumArray(int[] nums) {
        int len = nums.length;
        tree = new int[len + 1];

        this.nums = new int[len]; // can not use this.nums = nums, cuz we need to call update()!
        for (int i = 0; i < len; i++) update(i, nums[i]);
    }

    public static void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for (i++; i < tree.length; i += (i & (-i))) tree[i] += diff; // i & (-i) is lowbit.
    }

    public static int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
    private static int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= (i & (-i))) sum += tree[i]; // i & (-i) is lowbit.
        return sum;
    }

    public static void main(String[] args) {

        int[] A = {0, 9, 5, 7, 3};
        NumArray obj = new NumArray(A);
        System.out.println(sumRange(4, 4)); // 3
        System.out.println(sumRange(2, 4)); // 15
        update(4, 5); // {0, 9, 5, 7, (5)}
        System.out.println(sumRange(2, 4)); // 17
    }
}
/*
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */