package _Study.Problems.palindromicSubstringsTODO;

/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 *
 * // NOTE: Expand from center approach also exists for this problem. See 5. Longest Palindromic Substring
 *
 */
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Base case: single letter substrings
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Base case: double letter substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        // All other cases: substrings of length 3 to n
        for (int len = 3; len <= n; ++len) {
            for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }

        //int ans = Arrays.stream(dp).flatMap(x -> Arrays.stream(x)).mapToInt(i -> i ? 1 : 0).sum();
        //return ans;
        return -42;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countSubstrings("abc"));
        System.out.println(sol.countSubstrings("aaa"));
        System.out.println(sol.countSubstrings("aaab"));
    }
}