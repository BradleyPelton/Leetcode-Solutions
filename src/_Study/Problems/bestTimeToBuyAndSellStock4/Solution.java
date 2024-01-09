package _Study.Problems.bestTimeToBuyAndSellStock4;

class Solution {
    Integer[][] dp;
    public int maxProfit(int k, int[] prices) {  // Top Down - Accepted
        dp = new Integer[prices.length][k + 1];
        int ans = maxProfit(k, prices, 0);
        System.out.println(ans);
        return ans;
    }

    private int maxProfit(int remainingTransactions, int[] prices, int index) {
        if (remainingTransactions == 0 || index == prices.length) {
            return 0;
        }

        if (dp[index][remainingTransactions] != null) {
            return dp[index][remainingTransactions];
        }

        int doNothing = maxProfit(remainingTransactions, prices, index + 1);
        int buyAndSell = Integer.MIN_VALUE;
        for (int i = index + 1; i < prices.length ; i++) {
            if (prices[i] <= prices[index]) {
                break;
            }
            int localProfit = maxProfit(remainingTransactions - 1, prices, i) + (prices[i] - prices[index]);
            buyAndSell = Math.max(
                    buyAndSell,
                    localProfit
            );
        }
        int ans = Math.max(doNothing, buyAndSell);
        dp[index][remainingTransactions] = ans;
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProfit(
                2,
                new int[]{2,4,1}
        );
        sol.maxProfit(
                2,
                new int[]{3,2,6,5,0,3}
        );

    }
}