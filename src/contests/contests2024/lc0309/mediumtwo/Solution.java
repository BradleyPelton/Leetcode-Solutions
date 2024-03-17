package contests.contests2024.lc0309.mediumtwo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Accepted third attempt
// Logic bug in the first two attempts (over optimizing with a `continue`)
// accepted after 37 minutes

// Cleaned up while procrastinating hard

class Solution {
    class TrieNode {
        Set<Integer> indices;
        Map<Character, TrieNode> children;
        public TrieNode() {
            indices = new HashSet<>();
            children = new HashMap<>();
        }

        public TrieNode get(Character c) {
            return children.get(c);
        }

        public void put(Character c) {
            children.put(c, new TrieNode());
        }

        public boolean containsKey(Character c) {
            return children.containsKey(c);
        }
    }
    
    TrieNode root;
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        root = new TrieNode();
        buildTrie(arr);
        
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String word = arr[i];
            String localAnsString = "zzzzzzzzzzzzzzzzzzzzz"; // 21 Z's, longer than the longest possible substring
            int localAnsStringLength = Integer.MAX_VALUE;

            START_INDEX_LOOP:
            for (int startIndex = 0; startIndex < word.length(); startIndex++) {
                TrieNode currNode = root;
                int currSubStringLength = 0;
                for (int j = startIndex; j < word.length(); j++) {
                    currSubStringLength++;
                    if (currSubStringLength > localAnsStringLength) {
                        continue START_INDEX_LOOP;
                    }

                    currNode = currNode.get(word.charAt(j));
                    if (currNode.indices.size() == 1) {
                        String currString = word.substring(startIndex, j + 1);
                        if (localAnsStringLength > currSubStringLength) {
                            localAnsString = currString;
                            localAnsStringLength = currSubStringLength;
                        } else { // else localAnsStringLength == currSubStringLength
                            if (currString.compareTo(localAnsString) <= 0) {
                                localAnsString = currString;
                                localAnsStringLength = currSubStringLength;
                            }
                        }
                        continue START_INDEX_LOOP; // continuing the current substring will only result in a longer && lexicographically larger string
                    }
                }
            }

            if (localAnsStringLength == Integer.MAX_VALUE) {
                ans[i] = "";
            } else {
                ans[i] = localAnsString;
            }
        }

        //System.out.println(Arrays.toString(ans));
        return ans;
    }
    
    private void buildTrie(String[] arr) {
        for (int wordIndex = 0; wordIndex < arr.length; wordIndex++) {
            String word = arr[wordIndex];

            for (int startIndex = 0; startIndex < word.length(); startIndex++) {
                TrieNode currNode = root;

                for (int i = startIndex; i < word.length(); i++) {
                    if (!currNode.containsKey(word.charAt(i))) {
                        currNode.put(word.charAt(i));
                    }
                    currNode = currNode.get(word.charAt(i));
                    currNode.indices.add(wordIndex);
                }
            }
        }
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.shortestSubstrings(
                new String[]{"cab","ad","bad","c"}
        ); // ["ab","","ba",""]
        sol.shortestSubstrings(
                new String[]{"abc","bcd","abcd"}
        ); // ["","","abcd"]
        sol.shortestSubstrings(
                new String[]{"gfnt","xn","mdz","yfmr","fi","wwncn","hkdy"}
        ); // ["g","x","z","r","i","c","h"]
        sol.shortestSubstrings(
                new String[]{"vbb","grg","lexn","oklqe","yxav"}
        ); // ["b","g","n","k","a"]

    }
}