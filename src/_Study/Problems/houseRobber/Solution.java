package _Study.Problems.houseRobber;

import java.util.Arrays;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 *
 * <p>
 *     Dynamic Programming Approach:
 *     Time Complexity: Big O(n) - iterate through each element once
 *     Space Complexity: Big O(n) or Big O(1) - depending on if you reuse inputArr = dp or dp = new array
 * </p>
 */
class Solution {
    // NOTE: Greedy won't work. all evens and all odds won't work. Imagine 1,1,1,1,1,99999(odd),1,1,99999(even),1,1
    public int robBottomUp(int[] nums) { // DP - Bottom up - 100% runtime, 64% memory
        if (nums.length == 1) {
            return nums[0];
        }

        // Bottom Up.
        // Let dp[i] = the max to rob from nums[0..i];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(
                    dp[i - 1],
                    dp[i - 2] + nums[i]
            );
        }
        int ans = dp[nums.length - 1];
        System.out.println(ans);
        return ans;
    }

    int[] dp;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int ans = robTopDown(nums, nums.length - 1);
        System.out.println(ans);
        return ans;
    }

    private int robTopDown(int[] nums, int index) {
        if (dp[index] != Integer.MAX_VALUE) {
            return dp[index];
        }

        dp[index] = Math.max(
                robTopDown(nums, index - 1),
                robTopDown(nums, index - 2) + nums[index]
        );
        return dp[index];
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rob(new int[]{1,2,3,1});
        sol.rob(new int[]{2,7,9,3,1});
    }
}