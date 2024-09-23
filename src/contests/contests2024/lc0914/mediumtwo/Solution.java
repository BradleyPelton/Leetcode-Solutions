package contests.contests2024.lc0914.mediumtwo;


// Accepted second attempt
// First attmept wrong answer: edge case wrong return value

// Simple Trie application. Slight twist where we don't consider ".endsWith()"

class Solution {
    class TrieNode {
        boolean endsWord = false;
        TrieNode[] childrenNodes;
        public TrieNode() {
            childrenNodes = new TrieNode[26];
        }

        public TrieNode get(Character c) {
            return childrenNodes[c - 97];
        }

        public void put(Character c) {
            if (!containsKey(c)) {
                childrenNodes[c - 97] = new TrieNode();
            }
        }

        public boolean containsKey(Character c) {
            return childrenNodes[c - 97] != null;
        }
    }

    private void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode nextNode = root;
            for (char c : word.toCharArray()) {
                if (!nextNode.containsKey(c)) { // putIfAbsent() is a good alternative
                    nextNode.put(c);
                }
                nextNode = nextNode.get(c);
            }
            nextNode.endsWord = true;
        }
    }

    TrieNode root;
    String target;
    int n;
    Integer[] dp;
    public int minValidStrings(String[] words, String target) {
        root = new TrieNode();
        this.target = target;
        n = target.length();
        dp = new Integer[n];
        buildTrie(words);
        
        int ans = topDownDP(0);
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
        return ans;
    }

    public int topDownDP(int currIndex) {
        if (currIndex >= n) {
            return 0; // there are no more letters, so the cost is 0.
        }
        if (dp[currIndex] != null) { // if we've already calculated this index minCost
            return dp[currIndex];
        }

        int ans = Integer.MAX_VALUE;

        TrieNode currNode = root;
        for (int i = currIndex; i < n; i++) {
            char nextChar = target.charAt(i);
            if (!currNode.containsKey(nextChar)) {
                break; // no such word exists in the Trie, no point in continuing
            }
            currNode = currNode.get(nextChar); // step down the Trie

            int localAns = topDownDP(i + 1);
            // if localAns == Integer.MAX_VALUE, it's impossible to use this word as a substring of `target`
            if (localAns != Integer.MAX_VALUE) {
                localAns++;
                ans = Math.min(ans, localAns);
            }
        }

        dp[currIndex] = ans;
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minValidStrings(
                new String[]{"abc","aaaaa","bcdef"},
                "aabcdabc"
        ); // 3
        sol.minValidStrings(
                new String[]{"abababab","ab"},
                "ababaababa"
        ); // 2
        sol.minValidStrings(
                new String[]{"abcdef"},
                "xyz"
        ); // -1





    }
}
