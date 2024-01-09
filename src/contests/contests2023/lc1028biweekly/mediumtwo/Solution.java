package contests.contests2023.lc1028biweekly.mediumtwo;

import java.util.List;

// First Attempt TLE.
// I'll take it. I figured out the Recurrence relation pretty quickly
// Stumbled around the implementation of the recurrence relation for 45 minutes though
// I needed to implement the dp caching

class Solution {
    int[][] dp;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp = new int[nums.size() + 1][target + 1];
        int ans = lengthOfLongestSubsequence(nums, nums.size() -1 , target);
        if (ans <= 0) {
            return -1;
        }
        return ans;
    }

    private int lengthOfLongestSubsequence(List<Integer> nums, int right, int currSum) {
        if (right < 0) {  // break condition
            return Integer.MIN_VALUE;
        }
        if (dp[right][currSum] != 0) {
            return dp[right][currSum];
        }

        int nextVal = nums.get(right);
        if (nextVal > currSum) { // SKIP
            dp[right][currSum] = lengthOfLongestSubsequence(
                    nums,
                    right - 1,
                    currSum);
        } else if (nextVal == currSum) { // EITHER INCLUDE (which is now length 1) or skip.
            dp[right][currSum] = Math.max(1, lengthOfLongestSubsequence(
                    nums,
                    right - 1,
                    currSum));
        } else { // Both
            int leftMax = lengthOfLongestSubsequence(
                    nums,
                    right - 1,
                    currSum - nums.get(right)) + 1;
            int rightMax =
                    lengthOfLongestSubsequence(
                            nums,
                            right - 1,
                            currSum);
            dp[right][currSum] = Math.max(leftMax, rightMax);
        }
        return dp[right][currSum];
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubsequence(List.of(1,2,3,4,5), 9));
        System.out.println(sol.lengthOfLongestSubsequence(List.of(4,1,3,2,1,5), 7));
        System.out.println(sol.lengthOfLongestSubsequence(List.of(1,1,5,4,5), 3));
        System.out.println(sol.lengthOfLongestSubsequence(List.of(9,9), 3)); // expected 3
    }
}