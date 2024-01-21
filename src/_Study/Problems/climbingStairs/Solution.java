package _Study.Problems.climbingStairs;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 *
 *
 */
class Solution {
    public int climbStairs(int n) { // 100% runtime, 25% memory
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int ans = dp[n];
        System.out.println(ans);
        return ans;
    }

//    public int climbStairsMEMORYOPTIMIZEDDP(int n) { // 100% runtime, 32% memory
//        if (n == 1) {
//            return 1;
//        }
//        // Fibonacci
//        int twoStepsBack = 1; // 1
//        int oneStepBack = 2; // 2
//        for (int i = 3; i < n + 1; i++) {
//            int temp = oneStepBack + twoStepsBack;
//            twoStepsBack = oneStepBack;
//            oneStepBack = temp;
//        }
//        System.out.println(oneStepBack);
//        return oneStepBack;
//    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.climbStairs(2);
        sol.climbStairs(3);
        sol.climbStairs(45);
        sol.climbStairs(1);

    }
}
