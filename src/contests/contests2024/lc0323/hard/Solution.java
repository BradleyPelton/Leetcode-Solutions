package contests.contests2024.lc0323.hard;

import java.util.Arrays;

// Accepted first attempt
// Accepted after 14 minutes
// First Hard accepted ??? (previous hard accepted was retroactively rejected)
// Not a hard problem at all. TrieNode with suffixes, special sort logic while writing to the TrieNode

class Solution {
    class TrieNode {
        boolean endsWord = false;
        int shortestWordLength = Integer.MAX_VALUE;
        int shortestWordIndex = Integer.MAX_VALUE;
        TrieNode[] childrenNodes;
        public TrieNode() {
            childrenNodes = new TrieNode[26];
        }

        public TrieNode get(Character c) {
            return childrenNodes[c - 97];
        }

        public void put(Character c) {
            if (!containsKey(c)) { // not necessarily needed
                childrenNodes[c - 97] = new TrieNode();
            }
        }

        public boolean containsKey(Character c) {
            return childrenNodes[c - 97] != null;
        }
    }
    
    
    TrieNode root;
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        buildTrie(wordsContainer);

        int n = wordsQuery.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int localAns = root.shortestWordIndex;

            String word = wordsQuery[i];
            int wordLength = word.length();
            TrieNode currNode = root;
            for (int j = wordLength - 1; j >= 0; j--) {
                if (currNode.containsKey(word.charAt(j))) {
                    currNode = currNode.get(word.charAt(j));
                    localAns = currNode.shortestWordIndex;
                } else {
                    break;
                }
            }

            ans[i] = localAns;
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }

    private void buildTrie(String[] words) {
        root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordLength = word.length();

            // SET ROOT LENGTH
            if (root.shortestWordLength > wordLength) {
                root.shortestWordLength = wordLength;
                root.shortestWordIndex = i;
            }

            TrieNode currNode = root;
            for (int j = wordLength - 1; j >= 0; j--) {
                if (!currNode.containsKey(word.charAt(j))) {
                    currNode.put(word.charAt(j));
                }
                currNode = currNode.get(word.charAt(j));
                if (currNode.shortestWordLength > wordLength) {
                    currNode.shortestWordLength = wordLength;
                    currNode.shortestWordIndex = i;
                }
            }
            currNode.endsWord = true;
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.stringIndices(
                new String[]{"abcd","bcd","xbcd"},
                new String[]{"cd","bcd","xyz"}
        );
        sol.stringIndices(
                new String[]{"abcdefgh","poiuygh","ghghgh"},
                new String[]{"gh","acbfgh","acbfegh"}
        );
    }
}