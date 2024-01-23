package _Study.Problems.jumpGame;

import java.util.Arrays;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/
 *
 * // TODO - Backtracking solution
 * // TODO - Greedy solution
 */
class Solution {
    public boolean canJump(int[] nums) { // DP - Bottom up - 20% runtime, 32% memory
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2 ; i >= 0; i--) {
            int currJumpDistance = nums[i];
            if (i + currJumpDistance >= n - 1) {
                dp[i] = true;
            } else {
                for (int j = i + currJumpDistance; j > i; j--) {
                    if (dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        boolean ans = dp[0];
        System.out.println(ans);
        return ans;
    }

    public boolean canJumpTOPDOWN(int[] nums) {
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