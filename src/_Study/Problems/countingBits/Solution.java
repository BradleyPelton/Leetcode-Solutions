package _Study.Problems.countingBits;

import java.util.Arrays;

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/description/
 *
 * <p>
 *     Dynamic Programming Approach:
 *     Time Complexity: Big O(n) - single pass through each val
 *     Space Complexity: Big O(1) - nothing used besides the answer array which isn't included
 * </p>
 *
 * TODO - Theres some cool bit manipulation answers here. No idea how they work.
 *
 */
class Solution {
    int[] dp;
    public int[] countBits(int n) {
        if (n == 0) { return new int[]{0}; }
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int previousPowerOf2 = 1;
        int currIndex = 2;
        while (currIndex <= n) {
            for (int i = 1; i < previousPowerOf2; i++) {
                dp[currIndex] = 1 + dp[i];
                currIndex++;
                if (currIndex == n + 1) { return dp; }
            }
            dp[currIndex] = 1;
            currIndex++;
            if (currIndex == n + 1) { return dp; }
            previousPowerOf2 *= 2;
        }
        System.out.println(Arrays.toString(dp));
        return dp;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.countBits(0);
//        sol.countBits(1);
        sol.countBits(2);
//        sol.countBits(5);
//        sol.countBits(16); // expected [0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1]
//        System.out.println(Arrays.toString(sol.countBits(16))); // expected [0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1]
//        sol.countBits(30);
//        sol.countBits(31);
//        sol.countBits(32);
//        sol.countBits(33);
    }
}