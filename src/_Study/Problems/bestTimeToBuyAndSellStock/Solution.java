package _Study.Problems.bestTimeToBuyAndSellStock;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * (best time to buy and sell with single purchases)
 *
 * <p>
 *     Brute Force Approach:
 *     Time Complexity: Big O(n ** 2)
 *     Space Complexity: Big(1)
 * </p>
 *
 * <p>
 *     Dynamic Programming Approach:
 *     Time Complexity: Big O(n ** 2)
 *     Space Complexity: Big(1)
 * </p>
 *
 * NOTE: There is some other solution that tracks the lowest price. Seems very similar to Kadane's.
 *
 * // TODO - Top Down
 */
class Solution {
    public int maxProfit(int[] prices) { // BottomUp - Accepted
        if (prices.length == 0) { return 0; }

        for (int i = prices.length - 1; i > 0; i--) {
            prices[i] = prices[i] - prices[i - 1]; // turn prices array into priceDiff array
        }
        prices[0] = 0;

        // Now the problem is just the maxSubArray problem / Kadane's Algorithm
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            currSum = Math.max(currSum, 0) + prices[i];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProfit(new int[]{7,1,5,3,6,4});
//        sol.maxProfit(new int[]{7,6,4,3,1});
//        sol.maxProfit(new int[]{3,1});

    }
}