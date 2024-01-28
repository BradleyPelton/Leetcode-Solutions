package _Study.Problems.longestCommonSubsequence;

import java.util.Arrays;

/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/description/
 *
 *
 *
 * ALSO SEE: CLRS pg.394 (section 15.4 Dynamic Programming - Longest Common Subsequence)
 *
 * // TODO - return an (not necessarily unique) LCS String, not just the length.
 *
 */
class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) { // DP - Bottom Up - 82% runtime, 27% memory
        dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) { // alternatively, you can iterate in row-major reverse order.
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(
                            dp[i][j + 1],
                            dp[i + 1][j]
                    );
                }
            }
        }
        int ans = dp[text1.length()][text2.length()];
        System.out.println(ans);
        return ans;
    }

    public int longestCommonSubsequenceTOPDOWN(String text1, String text2) { // DP Top Down - 20% runtime, 78% runtime
        dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // tricky edge case. If you don't fill -1, Top down will TLE. 0 is both unknown and solved value
        }

        int ans = longestCommonSubsequenceTOPDOWN(text1, text2, 0, 0);
        System.out.println(ans);
        return ans;
    }

    private int longestCommonSubsequenceTOPDOWN(String text1, String text2, int index1, int index2) {
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }


        if (text1.charAt(index1) == text2.charAt(index2)) {
            dp[index1][index2] = longestCommonSubsequenceTOPDOWN(text1, text2, index1 + 1, index2 + 1) + 1;
        } else {
            dp[index1][index2] = Math.max(
                    longestCommonSubsequenceTOPDOWN(text1, text2, index1 + 1, index2),
                    longestCommonSubsequenceTOPDOWN(text1, text2, index1, index2 + 1)
            );
        }
        return dp[index1][index2];
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestCommonSubsequence("abcde", "ace");
        sol.longestCommonSubsequence("abc", "abc");
        sol.longestCommonSubsequence("abc", "");
        sol.longestCommonSubsequence("", "");
    }
}