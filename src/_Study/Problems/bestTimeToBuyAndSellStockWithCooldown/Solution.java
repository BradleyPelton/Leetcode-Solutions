package _Study.Problems.bestTimeToBuyAndSellStockWithCooldown;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * (buy time to buy and sell stock with 1 day cooldown)
 *
 * // TODO - Bottom Up DP - Space Optimized
 *
 */
class Solution {
    public int maxProfit(int[] prices) { // Bottom Up DP - 83% runtime, 21% memory
        int n = prices.length;
        if (n <= 1) {
            System.out.println("0, trivial length");
            return 0;
        }

        int[] holdingStock = new int[n];
        int[] notHoldingStock = new int[n];

        // First iteration
        holdingStock[0] = -prices[0]; // impossible
        notHoldingStock[0] = 0;

        // Second iteration
        holdingStock[1] = Math.max(holdingStock[0], -prices[1]);
        notHoldingStock[1] = Math.max(notHoldingStock[0], holdingStock[0] + prices[1]);

        // After you sell your stock, you cannot buy stock on the next day
        for (int i = 2; i < n; i++) {
            holdingStock[i] = Math.max(
                    holdingStock[i - 1], // don't sell
                    notHoldingStock[i - 2] - prices[i] // cooldown
            );

            notHoldingStock[i] = Math.max(
                    notHoldingStock[i - 1], // don't buy
                    holdingStock[i - 1] + prices[i]// sell
            );
        }

        return notHoldingStock[n - 1];
    }

    Integer[] dp;
    public int maxProfitTOPDOWN(int[] prices) { // Top Down DP - 18% runtime, 94% memory
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