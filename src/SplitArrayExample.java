package com.kunal;

public class SplitArrayExample {
    public static void main(String[] args) {
        // Example usage:
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        int result = splitArray(nums, m);
        System.out.println("The minimum largest sum after splitting into " + m + " subarrays is: " + result);
    }

    // https://leetcode.com/problems/split-array-largest-sum/
    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of the loop, this will contain the max item of the array
            end += nums[i];
        }

        // binary search
        while (start < end) {
            // try for the middle as a potential answer
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    // you cannot add this in this subarray, make a new one
                    // say you add this num in a new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end; // here start == end
    }
}
