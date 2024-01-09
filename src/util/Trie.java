package util;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/description
 *
 * TODO - Optimize
 * TODO - Highly dependent on the implementation of TrieNode
 */
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    private void buildTrie(String[] words) {
        root = new TrieNode();
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
