package com.company;

// ***
// LC 5.
// kthLargestElement
// ***

public class Main {

    public static int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (k > nums.length) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int start, int end, int k) {

        if (start == end) {
            return nums[end];
        }
        int i = start, j = end;
        int pivot = nums[i + (j - i) / 2];

        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }

        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
        return nums[j + 1];
    }

    public static void main(String[] args) {
        // write your code here

        int k = 6;
        int[] arr = new int[]{4,1,2,1,1};
        System.out.print(kthLargestElement(k, arr));
    }

}