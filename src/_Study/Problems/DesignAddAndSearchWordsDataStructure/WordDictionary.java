package _Study.Problems.designAddAndSearchWordsDataStructure;

/**
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 *
 * Twist on the Trie data structure to support '*' wildcard support.
 * Good solution, 73% Runtime, 35% memory
 */
class WordDictionary {
    TrieNode root;

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

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char nextChar : word.toCharArray()) {
            if (!node.containsKey(nextChar)) {
                node.put(nextChar);
            }
            node = node.get(nextChar);
        }
        node.endsWord = true;

    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.endsWord;
        }

        char nextChar = word.charAt(index);

        if (nextChar == '.') {
            for (char c = 'a'; c <= 'z'; c++) {
                if (node.containsKey(c)) {
                    boolean localSearch = search(word, node.get(c), index + 1);
                    if (localSearch) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (!node.containsKey(nextChar)) {
                return false;
            }
            return search(word, node.get(nextChar), index + 1);
        }
    }
}