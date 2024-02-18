package contests.contests2024.lc0217.mediumone;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

// Accepted after 13 minutes
// Clean double TrieNode implementation. Progress.

class Solution {

    // HASHMAP BASED
    class TrieNode {
        boolean endsWord = false;
        Map<Character, TrieNode> children;
        public TrieNode() {
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

    TrieNode rootOne;
    TrieNode rootTwo;
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        rootOne = new TrieNode();
        rootTwo = new TrieNode();
        buildTrieStructure(arr1, rootOne);
        buildTrieStructure(arr2, rootTwo);

        Queue<TrieNode[]> nodesToSearch = new ArrayDeque<>();
        nodesToSearch.add(new TrieNode[]{rootOne, rootTwo});

        int currDepth = 0;
        while (!nodesToSearch.isEmpty()) {
            int size = nodesToSearch.size();
            for (int i = 0; i < size; i++) {
                TrieNode[] nodePair = nodesToSearch.remove();
                TrieNode oneNode = nodePair[0];
                TrieNode twoNode = nodePair[1];

                for (char c : oneNode.children.keySet()) {
                    if (twoNode.containsKey(c)) {
                        nodesToSearch.add(new TrieNode[]{
                                oneNode.get(c),
                                twoNode.get(c)
                        });
                    }
                }
            }
            if (nodesToSearch.isEmpty()) {
                break;
            } else {
                currDepth++;
            }
        }

        System.out.println(currDepth);
        return currDepth;
    }

    private void buildTrieStructure(int[] nums, TrieNode root) {
        for (int num : nums) {
            TrieNode currNode = root;
            for (char c : String.valueOf(num).toCharArray()) {
                if (!currNode.children.containsKey(c)) {
                    currNode.children.put(c, new TrieNode());
                }
                currNode = currNode.children.get(c);
            }
            currNode.endsWord = true;
        }
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestCommonPrefix(
                new int[]{1,10,100},
                new int[]{1000}
        );
        sol.longestCommonPrefix(
                new int[]{1,2,3},
                new int[]{4,4,4 }
        );



    }
}
