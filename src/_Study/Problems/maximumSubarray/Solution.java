package _Study.Problems.maximumSubarray;


/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
 *
 * <p>
 *     Brute Force Approach:
 *     Time Complexity: Big O(n**2)
 *     Space Complexity: Big O(1)
 * </p>
 *
 * <p>
 *     Dynamic Programming, Kadane's Algorithm Approach
 *     Time Complexity: Big O(n)
 *     Space Complexity: Big O(1)
 *
 *     NOTES:
 *     - Every index could be the final index of our subarray
 *     - The maximum subarray at index i can be expressed recursively
 *          * dp[i] = max(dp[i-1], 0) + nums[i]
 * </p>
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(currSum, 0) + nums[i];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}