package _Study.Problems.wordBreakTODO;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 *
 * // TODO - BFS
 */
class Solution {
    class TrieNode {
        public TrieNode[] children;
        public boolean endsWord;

        public TrieNode() {
            children = new TrieNode[26];
            endsWord = false;
        }
    }

    TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) { // Bottom Up DP - 92% runtime, 75% memory
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        root = new TrieNode();
        buildTrieStructure(wordDict);

        for (int i = n - 1; i >= 0; i--) {
            TrieNode currNode = root;
            for (int j = i; j < n; j++) {
                if (currNode.children[s.charAt(j) - 'a'] != null) {
                    currNode = currNode.children[s.charAt(j) - 'a'];
                    if (currNode.endsWord && dp[j + 1]) {
                        dp[i] = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return dp[0];
    }

    Boolean[] dp;
    String s;
    int n;
    public boolean wordBreakTOPDOWN(String s, List<String> wordDict) { // Top Down DP with Trie - 91% runtime, 65% memory
        this.s = s;
        n = s.length();
        dp = new Boolean[n];
        root = new TrieNode();
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

        TrieNode currNode = root;
        boolean isPossible = false;
        for (int i = index; i < n; i++) {
            if (currNode.children[s.charAt(i) - 'a'] == null) {
                break;
            } else {
                currNode = currNode.children[s.charAt(i) - 'a'];

                if (currNode.endsWord) {
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
            TrieNode currNode = root;
            for (char c : word.toCharArray()) {
                if (currNode.children[c - 'a'] == null) {
                    currNode.children[c - 'a'] = new TrieNode();
                }
                currNode = currNode.children[c - 'a'];
            }
            currNode.endsWord = true;
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
