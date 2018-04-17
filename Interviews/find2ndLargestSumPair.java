package com.company;

public class Main {

    public static int find2ndLargestSumPair(int[] nums) {
        int largest = kthLargestElement(1, nums);
        int thirdLargest = kthLargestElement(3, nums);
        return largest + thirdLargest;
    }

    public static int kthLargestElement(int k, int[] nums) {
        // write your code here

        // QuickSelect
        if (nums == null || nums.length == 0) return 0;

        return quickSelect(k, nums, 0, nums.length - 1);
    }
    private static int quickSelect(int k, int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int pivot = (nums[left] + nums[right]) / 2;
        int i = left, j = right;
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (left + (k - 1) <= j) {
            return quickSelect(k, nums, left, j);
        }
        if (left + (k - 1) >= i) {
            return quickSelect(k - (i - left), nums, i, right);
        }
        return nums[j + 1];
    }

    public static void main(String[] args) {

        int[] nums = {1, -2, 3, 4, 9};
        int res = find2ndLargestSumPair(nums);
        System.out.println(res);
    }

}