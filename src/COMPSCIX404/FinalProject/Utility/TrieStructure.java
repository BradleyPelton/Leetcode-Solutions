package COMPSCIX404.FinalProject.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class TrieStructure {
    public TrieNode root;

    public TrieStructure() {}; // Restrict constructor access. See builder pattern below


    private void addWord(String word) {
        TrieNode nextNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!nextNode.containsKey(c)) {
                nextNode.put(c, word.substring(0, i + 1));
            }
            nextNode = nextNode.get(c);
        }
        nextNode.endsWord = true;
    }


    public static TrieStructure buildTrie(String[] words) {
        TrieStructure structure = new TrieStructure();
        structure.root = new TrieNode();
        for (String word : words) {
            structure.addWord(word);
        }
        return structure;
    }

    public static TrieStructure buildTrie(String filePath) {
        System.out.println("Starting build Trie from filePath");
        TrieStructure structure = new TrieStructure();
        structure.root = new TrieNode();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                structure.addWord(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("done reading");
        return null;
    }

    /**
     * Remove the word from the Trie. Remove any unused nodes after removing
     * the word.
     *
     * Stack approach.
     */
    public void removeWord(String word) {
        Stack<TrieNode> parentNodes = new Stack<>();
        parentNodes.add(root);

        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode = currentNode.get(c);
            parentNodes.add(currentNode);
        }

        // We are now at the end of the word.
        parentNodes.pop(); // pop the
        currentNode.endsWord = false;

        if (currentNode.children.isEmpty()) { // if the last node of the word is a leaf node
            for (int i = word.length() - 1; i >= 0; i--) {
                currentNode = parentNodes.pop(); // parent of the currentNode
                currentNode.removeChildNode(word.charAt(i));

                if (!currentNode.children.isEmpty()) {
                    break; // The parent node still has other
                }
            }
        }
    }
}
