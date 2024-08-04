package COMPSCIX404.FinalProject.Utility;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public boolean endsWord = false;
    Map<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<>();
    }

    public TrieNode get(Character c) {
        return children.get(c);
    }

    public void put(Character c, String word) {
        children.put(c, new TrieNode());
    }

    public boolean containsKey(Character c) {
        return children.containsKey(c);
    }

    public void removeChildNode(Character c) {
        children.remove(c);
    }
}
