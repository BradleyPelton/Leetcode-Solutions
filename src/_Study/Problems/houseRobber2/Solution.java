package _Study.Problems.houseRobber2;

import java.util.Arrays;

/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * This is a trick question. A cyclic house robber is just the house robber question applied to
 * two subarrays, [0..n-1] or [1,n]
 *
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            System.out.println(nums[0]);
            return nums[0];
        } else if (nums.length == 2) {
            int ans = Math.max(nums[0], nums[1]);
            System.out.println(ans);
            return ans;
        }

        int leftAns = robSubarray(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int rightAns = robSubarray(Arrays.copyOfRange(nums, 1, nums.length));
        int ans = Math.max(leftAns, rightAns);
        System.out.println(ans);
        return ans;
    }

    private int robSubarray(int[] nums) {  //
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(
                    dp[i - 2] + nums[i],
                    dp[i - 1]
            );
        }
        return dp[nums.length - 1];
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rob(new int[]{2,3,2});  // 3
        sol.rob(new int[]{1,2,3,1}); // 4
        sol.rob(new int[]{1,2,3}); // 3
        sol.rob(new int[]{1,2,1,1});  //expected 3
        sol.rob(new int[]{2,3});  //expected 3
    }
}