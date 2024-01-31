package _Study.Problems.wordBreakTODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 *
 *
 * // TODO  - DP bottom up
 * // TODO - BFS
 */
class Solution {
    class TrieNode {
        public Solution.TrieNode[] children;
        public boolean endsWords;

        public TrieNode() {
            children = new Solution.TrieNode[26];
            endsWords = false;
        }
    }

    Solution.TrieNode root;
    Boolean[] dp;
    String s;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) { // Top Down DP with Trie - 91% runtime, 65% memory
        this.s = s;
        n = s.length();
        dp = new Boolean[n];
        root = new Solution.TrieNode();
        buildTrieStructure(wordDict);
        boolean ans = wordBreak(0);
        System.out.println(ans);
        return ans;
    }

    private boolean wordBreak(int index) {
        if (index == n) {
            return true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        Solution.TrieNode currNode = root;
        boolean isPossible = false;
        for (int i = index; i < n; i++) {
            if (currNode.children[s.charAt(i) - 'a'] == null) {
                break;
            } else {
                currNode = currNode.children[s.charAt(i) - 'a'];

                if (currNode.endsWords) {
                    boolean truncate = wordBreak(i + 1);
                    if (truncate) {
                        isPossible = true;
                        break;
                    }
                }
            }

        }
        dp[index] = isPossible;
        return isPossible;
    }

    private void buildTrieStructure(List<String> words) {
        for (String word : words) {
            Solution.TrieNode currNode = root;
            for (char c : word.toCharArray()) {
                if (currNode.children[c - 'a'] == null) {
                    currNode.children[c - 'a'] = new Solution.TrieNode();
                }
                currNode = currNode.children[c - 'a'];
            }
            currNode.endsWords = true;
        }
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
