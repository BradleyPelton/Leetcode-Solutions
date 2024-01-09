package _Study.Problems.wordBreakTODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 *
 *
 * // TODO  BottomUp
 */
class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length() + 1];
        boolean ans = breakApart(s, wordDict);
        System.out.println(ans);
        return ans;
    }

    private boolean breakApart(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        if (dp[s.length()] != null) {
            return dp[s.length()];
        }

        boolean isPossible = false;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String newString = s.substring(word.length());
                isPossible |= breakApart(newString, wordDict);
            }
        }

        dp[s.length()] = isPossible;
        return isPossible;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.wordBreak("leetcode", List.of("leet","code"));  // true
//        sol.wordBreak("applepenapple", List.of("apple","pen")); // true
//        sol.wordBreak("catsandog", List.of("cats","dog","sand","and","cat")); // false
//        sol.wordBreak("a", List.of("b"));  // false
//        sol.wordBreak("abcd", List.of("a","abc","b","cd")); // expected true
        sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                new ArrayList<>(List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))); // expected false
    }
}
