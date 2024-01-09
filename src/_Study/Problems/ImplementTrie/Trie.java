package _Study.Problems.ImplementTrie;



import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/description
 *
 * TODO - Could be more optimized. 21% runtime / 48% memory
 *
 * See util.TrieNode for more
 */
class Trie {
    TrieNode root;


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

    public Trie() {
        root = new TrieNode();
    }

    private void buildTrie(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            TrieNode nextNode = root;
            for (char c : word.toCharArray()) {
                if (!nextNode.containsKey(c)) {
                    nextNode.put(c);
                }
                nextNode = nextNode.get(c);
            }
            nextNode.endsWord = true;
        }
    }

    public void insert(String word) {
        TrieNode nextNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!nextNode.containsKey(word.charAt(i))) {
                nextNode.put(word.charAt(i));
            }
            nextNode = nextNode.get(word.charAt(i));
        }
        nextNode.endsWord = true;
    }

    public boolean search(String word) {
        TrieNode nextNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!nextNode.containsKey(word.charAt(i))) {
                return false;
            }
            nextNode = nextNode.get(word.charAt(i));
        }
        return nextNode.endsWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode nextNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!nextNode.containsKey(prefix.charAt(i))) {
                return false;
            }
            nextNode = nextNode.get(prefix.charAt(i));
        }
        return true;
    }
}
