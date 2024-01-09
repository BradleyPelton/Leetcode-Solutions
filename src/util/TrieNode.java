package util;

import java.util.HashMap;
import java.util.Map;


// ARRAY BASED
// 1. More space
// 2. Less runtime
// 3. More runtime when searching for children (as opposed to just children.keySet()

//class TrieNode {
//    boolean endsWord = false;
//    TrieNode[] childrenNodes;
//    public TrieNode() {
//        childrenNodes = new TrieNode[26];
//    }
//
//    public TrieNode get(Character c) {
//        return childrenNodes[c - 97];
//    }
//
//    public void put(Character c) {
//        if (!containsKey(c)) { // not necessarily needed
//            childrenNodes[c - 97] = new TrieNode();
//        }
//    }
//
//    public boolean containsKey(Character c) {
//        return childrenNodes[c - 97] != null;
//    }
//}


// HASHMAP BASED
// 1. Less space
// 2. More runtime

// Allows any character, not just [0,25]
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

// TODO - Optionally include node.word for quick lookup without having to keep track of prefix as you traverse.


// MINIMALIST (do-it-yourself)
//class TrieNode {
//    boolean endsWord;
//    Map<Character, TrieNode> children = new HashMap<>();
//}