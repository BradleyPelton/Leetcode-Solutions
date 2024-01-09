package _Study.Problems.bestTimeToBuyAndSellStock2;

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * (best time to buy and sell with unlimited purchases)
 */
class Solution {
//    public int maxProfit(int[] prices) { // Greedy - Accepted
//        // Just sum all positive diffs?
//
//        int profitSum = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            int diff = prices[i + 1] - prices[i];
//            if (diff > 0) { profitSum += diff; }
//        }
//        // System.out.println("ans = " + profitSum);
//        return profitSum;
//    }
    public int maxProfit(int[] prices) { // Recursion - Untested
        int ans = maxProfit(prices, 0, -1);
        System.out.println(ans);
        return ans;
    }

    public int maxProfit(int[] prices, int index, int buyIndex) {
        if (index == prices.length) {
            return 0;
        }

        int doNothing = Integer.MIN_VALUE;
        int sellAtCurrent = Integer.MIN_VALUE;
        int buyAtCurrent = Integer.MIN_VALUE;

        if (index == prices.length - 1) { // last day. forced to sell.
            if (buyIndex == -1) {
                doNothing = maxProfit(prices, index + 1, buyIndex);
            } else {
                sellAtCurrent = maxProfit(prices, index, -1) + (prices[index] - prices[buyIndex]);
            }
        } else {
            doNothing = maxProfit(prices, index + 1, buyIndex);
            if (buyIndex == -1) {
                buyAtCurrent = maxProfit(prices, index + 1, index);
            } else {
                sellAtCurrent = maxProfit(prices, index, -1) + (prices[index] - prices[buyIndex]);
            }
        }

        int ans = Math.max(doNothing, Math.max(sellAtCurrent, buyAtCurrent));
        return ans;
    }
}
