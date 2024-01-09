package _Study.Problems.jumpGame;

import java.util.Arrays;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/
 *
 */
class Solution {
    public boolean canJumpBottomUp(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i] is the minimum number of jumps needed to get to the end
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length - 1] = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            int jumpLength = nums[i];
            if (i + jumpLength >= nums.length - 1) {
                dp[i] = 1; // one jump solution
            } else {
                for (int j = 1; j <= jumpLength && i + j < nums.length - 1; j++) {
                    if (dp[i + j] == Integer.MAX_VALUE) { continue; }
                    dp[i] = Math.min(dp[i], dp[i + j] + 1);
                }
            }
        }
        return dp[0] != Integer.MAX_VALUE; // if non infinity, then it's possible.
    }

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length - 1] = 0;

        numberOfJumpsFromIndex(nums, dp, 0);
        boolean isPossible = dp[0] != Integer.MAX_VALUE;
        System.out.println(isPossible);
        return isPossible;
    }

    private int numberOfJumpsFromIndex(int[] nums, int[] dp, int index) {
        if (dp[index] != Integer.MAX_VALUE) {
            return dp[index];
        }
        int jumpLength = nums[index];
        if (index + jumpLength >= nums.length - 1) {
            dp[index] = 1; // one jump solution
            return 1;
        } else {
            for (int j = 1; j <= jumpLength && index + j < nums.length - 1; j++) {
                int jumpsFromMiddle = numberOfJumpsFromIndex(nums, dp, index + j);
                if (jumpsFromMiddle == Integer.MAX_VALUE) { continue; }
                dp[index] = Math.min(dp[index], jumpsFromMiddle + 1);
            }
            return dp[index];
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canJump(new int[]{2,3,1,1,4});
        sol.canJump(new int[]{3,2,1,0,4});
    }
}