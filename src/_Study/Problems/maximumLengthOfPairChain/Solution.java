package _Study.Problems.maximumLengthOfPairChain;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 *
 *
 * TODO  : see https://leetcode.com/problems/non-overlapping-intervals/
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        // Greedy is the canonical solution for interval scheduling. See CLRS chapter 16.1


        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        // Let dp[i] represent the most intervals in pairs[0..i]

        int[] previousPair = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            int[] nextPair = pairs[i];
            if (previousPair[1] < nextPair[0]) {
                dp[i] = dp[i - 1] + 1;
                previousPair = nextPair;
            } else {
                dp[i] = dp[i - 1]; // always keep the previousInterval which has a smaller finish time
            }
        }

        int ans = dp[pairs.length - 1];
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findLongestChain(new int[][]{{1,2},{2,3},{3,4}});
        sol.findLongestChain(new int[][]{{1,2},{7,8},{4,5}});
    }
}
