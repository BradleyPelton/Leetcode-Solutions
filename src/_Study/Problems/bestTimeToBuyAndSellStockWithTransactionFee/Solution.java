package _Study.Problems.bestTimeToBuyAndSellStockWithTransactionFee;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 *
 * Not an oridinary DP question. State Transition.
 * // TODO - Bottom Up
 */
class Solution {
    Integer[] dp;
    public int maxProfit(int[] prices, int fee) { // Top Down - Accepted after slight optimization (break;)
        dp = new Integer[prices.length];
        int ans = maxProfit(prices, fee, 0);
        System.out.println(ans);
        return ans;
    }

    private int maxProfit(int[] prices, int fee, int index) {
        if (index == prices.length) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int doNothing = maxProfit(prices, fee, index + 1);
        int buyAtCurrent = Integer.MIN_VALUE;
        for (int i = index + 1; i < prices.length; i++) {
            if (prices[index] > prices[i]) {
                break;
            }

            int localProfit = prices[i] - prices[index] - fee + maxProfit(prices, fee, i); // GO FORWARDS
            buyAtCurrent = Math.max(
                    buyAtCurrent,
                    localProfit
            );
        }
        int ans = Math.max(doNothing, buyAtCurrent);
        dp[index] = ans;
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProfit(
                new int[]{1,3,2,8,4,9},
                2
        );
        sol.maxProfit(
                new int[]{1,3,7,5,10,3},
                3
        );
    }
}