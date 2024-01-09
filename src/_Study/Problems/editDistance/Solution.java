package _Study.Problems.editDistance;

import java.util.Arrays;

/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/description/
 *
 * // TODO - Bottom up DP
 */
class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        if ("".equals(word1)) {
            return word2.length();
        } else if ("".equals(word2)) {
            return word1.length();
        }

        // THEORY: Since any action is invertible, minDistance(word1,word2) == minDistance(word2,word1). Order doesn't matter
        // WLOG, we will convert shorter word to longer word.
        // WLOG, we will convert word1 -> word2 , where word1 is the shorter or same length word.

        if (word1.length() > word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        dp = new int[word1.length()][word2.length()];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minDistance(word1, word2, 0, 0); // was able to reverse iteration order successfully
        int ans = dp[0][0];
        System.out.println(ans);
        return ans;
    }

    public int minDistance(String word1, String word2, int word1Index, int word2Index) {
        if (word1Index == word1.length() && word2Index == word2.length()) {
            return 0; // finished
        }

        if (word1Index == word1.length() && word2Index <= word2.length() - 1) {
            // Number of insertions to finish
            return word2.length() - word2Index;
        }
        if (word2Index == word2.length() && word1Index <= word1.length() - 1) {
            return word1.length() - word1Index;
        }

        if (dp[word1Index][word2Index] != Integer.MAX_VALUE) {
            return dp[word1Index][word2Index];
        }

        if (word1.charAt(word1Index) == word2.charAt(word2Index)) {
            dp[word1Index][word2Index] = minDistance(word1, word2, word1Index + 1, word2Index + 1);
        } else {
            int insertAction = minDistance(word1, word2, word1Index, word2Index + 1); // word1 stays the same
            int removeAction = minDistance(word1, word2, word1Index + 1, word2Index);
            int replaceAction = minDistance(word1, word2, word1Index + 1, word2Index + 1);
            int minOfThreeActions = Math.min(insertAction, Math.min(removeAction, replaceAction)) + 1;
            dp[word1Index][word2Index] = minOfThreeActions;
        }
        return dp[word1Index][word2Index];
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minDistance("horse", "ros");
        sol.minDistance("intention", "execution");
    }
}