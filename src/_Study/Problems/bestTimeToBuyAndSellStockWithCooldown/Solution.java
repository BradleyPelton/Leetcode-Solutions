package _Study.Problems.bestTimeToBuyAndSellStockWithCooldown;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * (buy time to buy and sell stock with 1 day cooldown)
 */
class Solution {

    Integer[] dp;
    public int maxProfit(int[] prices) { // Top Down - Accepted
        dp = new Integer[prices.length];
        int ans = maxProfit(prices, 0);
        System.out.println(ans);
        return ans;
    }

    private int maxProfit(int[] prices, int index) {
        if (index >= prices.length) { // no point in buying on the last day
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int doNothing = maxProfit(prices, index + 1);
        int buyAtCurrent = Integer.MIN_VALUE;
        for (int i = index + 1; i < prices.length; i++) {
            if (prices[i] < prices[index]) { // it would have been better to just doNothing.
                break;
            }
            int localProfit = maxProfit(prices, i + 2) + prices[i] - prices[index];
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
        sol.maxProfit(new int[]{1,2,3,0,2});
        sol.maxProfit(new int[]{1});
    }
}