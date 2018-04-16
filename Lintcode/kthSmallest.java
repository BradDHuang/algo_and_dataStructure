package com.company;

// LC 461. Kth Smallest Number in Unsorted Array

public class Main {
    public static int kthSmallest(int k, int[] nums) {

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
            return nums[start];
        }
//        int pivot = start + (end - start)/2;
        int pivot = nums[start + (end - start)/2];
        int i = start, j = end;
        while (i <= j) {
            while(i <= j && nums[i] < pivot) {
                i++;
            }
            while(i <= j && nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;

                i++;
                j--;
            }
        }

        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        } else if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        } else {
            return nums[j + 1];
        }
    }


    public static void main(String[] args) {
        // write your code here

        int[] nums = new int[]{1, 3, 5, 7, 3};

        System.out.println(kthSmallest(4, nums));
    }
}