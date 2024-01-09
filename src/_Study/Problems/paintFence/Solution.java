package _Study.Problems.paintFence;

/**
 * 276. Paint Fence
 * https://leetcode.com/problems/paint-fence/
 *
 * // TODO NOTE: I struggled a lot with this recurrence relation. Study counting/probability
 */
class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            System.out.println(0);
            return 0;
        }  else if (n == 1) {
            System.out.println(k);
            return k;
        } else if (n == 2) {
            System.out.println(k * k);
            return k * k;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        } // TODO NOTE: I struggled a lot with this recurrence relation. Study counting/probability

        int ans = dp[n];
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numWays(3, 2);
        sol.numWays(1, 1);
        sol.numWays(7, 2);
        sol.numWays(3, 1);  // 0
        sol.numWays(3, 3);  // 24
    }
}