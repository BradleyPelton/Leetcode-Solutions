package _Study.Problems.coins2TODO;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 518. Coin Change II
 * https://leetcode.com/problems/coin-change-ii/description/
 *
 * This is a classical Dynamic Programming problem
 *
 * I struggled with this because it required the combinations to be unique.
 *
 * // TODO - Redo fresh.
 * // TODO - BottomUp
 */
class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        coins = Arrays.stream(coins).boxed().sorted(Comparator.comparingInt(a -> -a)).mapToInt(i -> i).toArray();
        int ans = change(amount, coins, 0, 0);
        System.out.println(ans);
        return ans;
    }

    private int change(int target, int[] coins, int index, int currSum) {
        if (currSum == target) {
            return 1;
        } else if (currSum > target) {
            return 0;
        } else if (index == coins.length) {
            return 0;
        }

        if (dp[index][currSum] != null) {
            return dp[index][currSum];
        }

        int numOfWays = 0;
        int coinVal = coins[index];
        for (int multiple = 0; multiple <= Integer.MAX_VALUE ; multiple++) {
            if (multiple * coinVal <= target) {
                int localWays = change(target, coins, index + 1, currSum + (coinVal * multiple));
                numOfWays += localWays;
            } else {
                break;
            }
        }
        dp[index][currSum] = numOfWays;
        return numOfWays;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.change(500, new int[]{1,2,5});
        sol.change(3, new int[]{2});
        sol.change(10, new int[]{10});
    }
}