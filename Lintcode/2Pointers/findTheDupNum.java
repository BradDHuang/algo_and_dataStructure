package com.company;

// lc 633.

public class Main {

    public static int findDuplicate(int[] nums) {
        // Write your code here
//        You must not modify the array (assume the array is read only).
//        You must use only constant, O(1) extra space.
//        Your runtime complexity should be less than O(n^2).
//        There is only one duplicate number in the array, but it could be repeated more than once.

        // O(n) solution, we use slow/fast pointers to find the cycle and the dup.
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) { // find the cycle.
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) { // looking for the dup.
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
        // note: when slow/fast met at point A, say slow had N steps, then fast must had 2*N steps;
        // we set fast to index 0 and it moves 1 step by 1 step, and then slow/fast will finally met at point A again,
        // so, they must have met at the start of the cycle.
    }

    public static void main(String[] args) {
        System.out.println();
    }

}