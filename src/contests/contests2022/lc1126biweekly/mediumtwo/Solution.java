package contests.contests2022.lc1126biweekly.mediumtwo;

import java.util.Arrays;

class Solution {
    public int minimumCoins(int[] prices) { // Bottom Up
        int n = prices.length;
        int[] dp = new int[n + 1];
        // let dp[i] = the min price it cost to purchase prices[i..] (all items from i,...,n

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0; // All items after the last item are trivially free.

        for (int i = prices.length - 1; i >= 0; i--) {
            int indexOfLastFreeItem = i + i + 1;

            for (int j = i + 1; j <= indexOfLastFreeItem + 1 && j <= n; j++) {
                dp[i] = Math.min(dp[i], prices[i] + dp[j]);
            }
        }
        return dp[0];
    }


//    Integer[] dp;
//    public int minimumCoins(int[] prices) { // Top Down ACCEPTED
//        dp = new Integer[prices.length + 2];
//        return minimumCoins(prices, 0);
//    }
//
//    public int minimumCoins(int[] prices, int index) {
//        if (index >= prices.length) {
//            return 0;
//        }
//
//        if (dp[index] != null) {
//            return dp[index];
//        }
//
//        int indexOfLastFreeItem = index + index + 1;
//
//        int exclusive = prices[index] + minimumCoins(prices, indexOfLastFreeItem + 1);
//        int inclusive = Integer.MAX_VALUE;
//        for (int i = index + 1; i <= indexOfLastFreeItem && i <= prices.length; i++) {
//            int skipScore = minimumCoins(prices, i) + prices[index];
//            inclusive = Math.min(inclusive, skipScore);
//        }
//        int ans = Math.min(exclusive, inclusive);
//        dp[index] = ans;
//        return ans;
//    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumCoins(new int[]{3,1,2});  // 4
        sol.minimumCoins(new int[]{1,10,1,1});  // 2
        sol.minimumCoins(new int[]{26,18,6,12,49,7,45,45});  // 39



    }
}
