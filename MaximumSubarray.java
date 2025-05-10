// Leetcode Question 53 Dynamic Programming

// Example 1:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

// Example 2:
// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.

// Example 3:
// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.



package org.example;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // maxSoFar = Maximum sum of the Subarray found so far
        // currentMax = Maximum sum ending at the current index
        // Both are initialized to the first element of the array nums[0]
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        // Iterate through the array starting from the second element nums[1]
        // If the Array is [-2, -5, 6, -2, -3] it will start from pos 1 (Value -5)
        // currentMax = -5 || maxSoFar = -2
        for (int i = 1; i < nums.length; i++){
            // Compare currentMax with the current element at nums[i]
            // If the maximum sum of the (previous subarrays + currentMax) is bigger than the current Value nums[i]
            // Extend currentMax
            // If the current Value nums[i] is bigger
            // Start a new subarray
            currentMax = Math.max(nums[i], nums[i] + currentMax);
            
            // Update maxSoFar by comparing currentMax and previous maxSoFar
            maxSoFar = Math.max(currentMax, maxSoFar);
        }
        // Return the maximum sum of the subarray
        return maxSoFar;


    }
    
}
