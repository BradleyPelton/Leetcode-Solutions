package _Study.Problems.coinChangeTODO;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/
 *
 * // TODO - Fix Top Down DP;
 *
 */
class Solution {
//    int[] dp;
//    public int coinChange(int[] coins, int amount) {
//        dp = new int[amount + 1]; // lot of memory used... 10,000 element array
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i = 0; i < amount + 1; i++) {
//            for (int coinVal : coins) {
//                if (i - coinVal < 0 || dp[i - coinVal] == Integer.MAX_VALUE) {
//                    continue;
//                }
//                dp[i] = Math.min(dp[i], dp[i - coinVal] + 1);
//            }
//        }
//        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
//    }

    Integer[][] dp;
    public int coinChange(int[] coins, int amount) { // TODO - Top Down DP doesn't need 2 state variables
        dp = new Integer[amount + 1][coins.length];
        coins = Arrays.stream(coins).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        int ans = coinChange(coins, amount, 0);
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
        return ans;
    }

    private int coinChange(int[] coins, int remainingAmount, int coinIndex) { // Top Down Dp - 12% runtime, 5% memory
        if (remainingAmount == 0) {
            return 0;
        }

        if (coinIndex == coins.length) {
            return Integer.MAX_VALUE;
        }

        if (dp[remainingAmount][coinIndex] != null) {
            return dp[remainingAmount][coinIndex];
        }

        int minCoins;
        if (remainingAmount < coins[coinIndex]) {
            minCoins = coinChange(coins, remainingAmount, coinIndex + 1);
        } else {
            int doNothing = coinChange(coins, remainingAmount, coinIndex + 1);
            int popRight = coinChange(coins, remainingAmount - coins[coinIndex], coinIndex);
            if (popRight != Integer.MAX_VALUE) {
                popRight++;
            }
            minCoins = Math.min(doNothing, popRight);
        }

        dp[remainingAmount][coinIndex] = minCoins;
        return minCoins;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{1,2,5}, 11));
        System.out.println(sol.coinChange(new int[]{2}, 3));
        System.out.println(sol.coinChange(new int[]{1}, 0));
        System.out.println(sol.coinChange(new int[]{2,5,10,1}, 27));  // 4
        System.out.println(sol.coinChange(new int[]{2}, 1));  // -1
        System.out.println(sol.coinChange(new int[]{186,419,83,408}, 6249));  // 20
    }
}