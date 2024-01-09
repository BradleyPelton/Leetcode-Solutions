package _Study.Problems.bestTimeToBuyAndSellStock3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * (best time to buy and sell with at most 2 purchases)
 *
 * Attempts:
 *  1. TLE: Iterating over 0 < midpoint < n and running Kadane's on both halves.
 *  2. TLE: Iterating over 0 < midpoint < n and running Kadane's on both halves (caching left half)
 *  3. Memory Limited Exceeded: Caching dp[i][j] = maxProfit(nums[i..j])
 */
class Solution {
    public int maxProfit(int[] prices) {
        return -42;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProfit(new int[]{3,3,5,0,0,3,1,4});
        sol.maxProfit(new int[]{1,2,3,4,5});
        sol.maxProfit(new int[]{7,6,4,3,1});
    }
}
