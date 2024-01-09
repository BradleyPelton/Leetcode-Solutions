package _Study.Problems.longestPalindromicSubsequence;

import java.util.Arrays;

/**
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * // TODO - DP bottom up
 *
 * // TODO - Iterative center-out solution
 *
 */
class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = longestPalindromeSubseq(s, 0, s.length() - 1);
        System.out.println(ans);
        return ans;
    }
    public int longestPalindromeSubseq(String s, int leftIndex, int rightIndex) {
        if (leftIndex == s.length() || leftIndex > rightIndex) {
            return 0;
        } else if (leftIndex == rightIndex) {
            return 1;
        } else if (leftIndex == rightIndex - 1) {
            if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                return 2;
            } else {
                return 1;
            }
        }

        if (dp[leftIndex][rightIndex] != -1) {
            return dp[leftIndex][rightIndex];
        }

        char leftChar = s.charAt(leftIndex);

        // INCLUSIVE
        int inclusiveLength;
        int lastOccOfChar = s.lastIndexOf(leftChar, rightIndex);
        if (lastOccOfChar == leftIndex) {
            inclusiveLength = Integer.MIN_VALUE;  // char never appears again
        } else {
            inclusiveLength = longestPalindromeSubseq(s, leftIndex + 1, lastOccOfChar - 1) + 2;
        }

        // EXCLUSIVE
        int exclusiveLength = longestPalindromeSubseq(s, leftIndex + 1, rightIndex);


        int ans = Math.max(inclusiveLength, exclusiveLength);
        dp[leftIndex][rightIndex] = ans;
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestPalindromeSubseq("bbbab");
        sol.longestPalindromeSubseq("cbbd");
    }
}
