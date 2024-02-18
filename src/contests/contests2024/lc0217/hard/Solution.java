package contests.contests2024.lc0217.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// First Attempt: TLE
// Second Attempt: Wrong Answer
// Third Attempt: Wrong Answer

class Solution {
    class TrieNode {
        boolean endsWord = false;
        TrieNode[] children;
//        int endsWordIndex;
//        int indicesGreater;
        Map<Integer, Integer> indicesGreater;
        public TrieNode() {
            children = new TrieNode[26];
//            endsWordIndex = -1;
//            indicesGreater = 0;
        }
    }


    TrieNode rootStartsWith;
    TrieNode rootEndsWith;
    public long countPrefixSuffixPairs(String[] words) {
        rootStartsWith = new TrieNode();
        rootEndsWith = new TrieNode();
        buildTrieForward(words);
        buildTrieBackward(words);

        long ans = 0;
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String word = words[wordIndex];
            TrieNode forwardNode = rootStartsWith;
            for (char c : word.toCharArray()) {
                forwardNode = forwardNode.children[c - 'a'];
            }
            TrieNode backwardNode = rootEndsWith;
            for (int i = word.length() - 1; i >= 0; i--) {
                backwardNode = backwardNode.children[word.charAt(i) - 'a'];
            }

            int localGreaterForward = forwardNode.indicesGreater.get(wordIndex);
            int localGreaterBackward = backwardNode.indicesGreater.get(wordIndex);
            int localAns = Math.min(localGreaterBackward, localGreaterForward);
            ans += localAns;

//            List<Integer> forwardIndices = forwardNode.indices;
//            List<Integer> backwardIndices = backwardNode.indices;
//            int forwardIndex = 0;
//            int backwardIndex = 0;
//            while (forwardIndex < forwardIndices.size()) {
//                if (forwardIndices.get(forwardIndex) <= wordIndex) {
//                    forwardIndex++;
//                } else {
//                    break;
//                }
//            }
//            while (backwardIndex < backwardIndices.size()) {
//                if (backwardIndices.get(backwardIndex) <= wordIndex) {
//                    backwardIndex++;
//                } else {
//                    break;
//                }
//            }
//
//            while (true) {
//                if (forwardIndex >= forwardIndices.size()) {
//                    break;
//                }
//                if (backwardIndex >= backwardIndices.size()) {
//                    break;
//                }
//                int forwardVal = forwardIndices.get(forwardIndex);
//                int backwardVal = backwardIndices.get(backwardIndex);
//                if (forwardVal == backwardVal) {
//                    ans++;
//                    forwardIndex++;
//                    backwardIndex++;
//                } else if (forwardVal > backwardVal) {
//                    backwardIndex++;
//                } else {
//                    forwardIndex++;
//                }
//            }
        }

        System.out.println(ans);
        return ans;
    }

    private void buildTrieForward(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode currNode = rootStartsWith;
            for (char c : word.toCharArray()) {
                if (currNode.children[c - 'a'] == null) {
                    currNode.children[c - 'a'] = new TrieNode();
                }
                currNode = currNode.children[c - 'a'];
                if (currNode.endsWord) {
                    for (int key : currNode.indicesGreater.keySet()) {
                        if (key < i) {
                            currNode.indicesGreater.put(key, currNode.indicesGreater.get(key) + 1);
                        }
                    }
                }
            }
            currNode.endsWord = true;
            if (currNode.indicesGreater == null) {
                currNode.indicesGreater = new HashMap<>();
            }
            currNode.indicesGreater.put(i, 0);
        }
    }
    private void buildTrieBackward(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode currNode = rootEndsWith;
            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                if (currNode.children[c - 'a'] == null) {
                    currNode.children[c - 'a'] = new TrieNode();
                }
                currNode = currNode.children[c - 'a'];
                if (currNode.endsWord) {
                    for (int key : currNode.indicesGreater.keySet()) {
                        if (key < i) {
                            currNode.indicesGreater.put(key, currNode.indicesGreater.get(key) + 1);
                        }
                    }
                }
            }
            currNode.endsWord = true;
            if (currNode.indicesGreater == null) {
                currNode.indicesGreater = new HashMap<>();
            }
            currNode.indicesGreater.put(i, 0);
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.countPrefixSuffixPairs(
//                new String[]{"a","aba","ababa","aa"}
//        ); // 4
//        sol.countPrefixSuffixPairs(
//                new String[]{"pa","papa","ma","mama"}
//        ); // 2
//        sol.countPrefixSuffixPairs(
//                new String[]{"abab","ab"}
//        ); // 0
//        sol.countPrefixSuffixPairs(
//                new String[]{"a","a"}
//        ); // 1
        sol.countPrefixSuffixPairs(
                new String[]{"c","aac","cb"}
        ); // 0
    }
}
