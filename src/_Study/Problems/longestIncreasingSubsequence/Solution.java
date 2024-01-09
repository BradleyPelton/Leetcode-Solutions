package _Study.Problems.longestIncreasingSubsequence;

import java.util.Arrays;

// TLE First Attempt
// TLE Second Attempt


/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/description
 *
 * <p>
 *     Dynamic Programming Approach:
 *     Time Complexity: Big O(n**2) - for each element, iterate over all elements to the left
 *     Space Complexity: Big O(n) - dp array
 * </p>
 *
 * <p>
 *     Binary Search Approach:
 *     Time Complexity: Big (n * log n)
 * </p>
 *
 */
class Solution {
    public int lengthOfLIS(int[] nums) { // Bottom Up DP - 65% runtime, 65% memory
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] represent the longest increasing subsequence that ENDS with i;
        Arrays.fill(dp, 1); // all length==1 is trivially true

        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) { // iterate over all elements to the left of i (which are already solved)
                if (nums[j] < nums[i]) {
                    int localMax = Math.max(
                            dp[i],
                            dp[j] + 1
                    );
                    maxLength = Math.max(maxLength, localMax);
                    dp[i] = localMax;
                }
            }
        }
        return maxLength;
    }

//    Integer[] dp;
//    public int lengthOfLIS(int[] nums) {   // Top Down DP - 18% runtime, 26% memory
//        dp = new Integer[nums.length];
//
//        int maxLength = 1;
//        for (int lastIndex = 0; lastIndex < nums.length; lastIndex++) { // we have to check each index or potential miss
//            int localLength = lengthOfLIS(nums, lastIndex);
//            maxLength = Math.max(maxLength, localLength);
//        }
//
//        System.out.println(maxLength);
//        return maxLength;
//    }
//
//    private int lengthOfLIS(int[] nums, int index) {
//        if (index == nums.length) {
//            return 0;
//        }
//
//        if (dp[index] != null) {
//            return dp[index];
//        }
//
//        int maxLength = 1;
//        for (int i = 0; i < index; i++) {
//            if (nums[index] > nums[i]) {
//                int localLength = lengthOfLIS(nums, i) + 1;
//                maxLength = Math.max(maxLength, localLength);
//            }
//        }
//        dp[index] = maxLength;
//        return maxLength;
//    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(sol.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(sol.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}