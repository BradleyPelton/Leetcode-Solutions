package COMPSCIX404.AssignmentFive;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Title: Assignment 05 - COMPSCIX404.1-019
 * Student: Bradley Pelton
 * Date: 2024-07-13
 */

public class Assignment_Five_Bradley_Pelton {
    // The questions are broken up into the 4 classes below. This class does not execute anything.
    QuestionOne q1 = new QuestionOne();
    QuestionTwo q2 = new QuestionTwo();
    QuestionThree q3 = new QuestionThree();
    QuestionFour q4 = new QuestionFour();
}

class QuestionOne {
    class NaryTreeNode { // "N-ary" tree
        List<NaryTreeNode> childrenNodes;
    }
    /**
     * Return the last node of a tree(that is backed by an array)
     */
    public int lastNodeInCompleteTree(int[] treeAsArray) {
        return treeAsArray[treeAsArray.length - 1];
    }

    /**
     * Return the last node of a tree (backed by standard Node structure)
     * <p>
     * Get the last node by performing Breadth-First search.
     * Maintain the current "level" in a Queue. Since the tree is complete,
     * the last node is guaranteed to further right node of the last level.
     * </p>
     */
    public NaryTreeNode lastNodeInCompleteTree(NaryTreeNode root) {
        // Find the last node by using Breadth-first search
        Deque<NaryTreeNode> nodesToSearch = new ArrayDeque<>(); // Fun fact: ArrayDeque is more performant than Queue
        nodesToSearch.add(root);

        // Similar logic to shortest path algorithms.
        // Handle the nodes in the Queue level by level.
        // Check the size of the level before popping from the queue.
        NaryTreeNode lastNode = root;
        while (!nodesToSearch.isEmpty()) {
            // the further right node of a complete tree is always the last node of the last level
            lastNode = nodesToSearch.peekLast(); // furthest right node of the current level
            int numberOfNodesInCurrentLevel = nodesToSearch.size();

            for (int i = 0; i < numberOfNodesInCurrentLevel; i++) {
                NaryTreeNode currNode = nodesToSearch.removeFirst();
                for (NaryTreeNode childNode : currNode.childrenNodes) { // NOTE: currNode.childrenNodes is ordered
                    nodesToSearch.addLast(childNode); // add the children to the next level
                }
            }
        }

        return lastNode;
    }
}

class QuestionTwo {
    /**
     * Given a string, return a char[] of its characters
     * sorted by frequency.
     */
    public char[] charactersSortedByFrequency(String inputString) {
        // Count the frequency of each character in inputString
        Map<Integer, Integer> characterFrequency = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            Integer charAsInt = (int) c;
            characterFrequency.put(charAsInt, characterFrequency.getOrDefault(charAsInt, 0) + 1);
        }

        // Create a max heap
        // Sort the characters as pairs of [CHARACTER, FREQUENCY]
        PriorityQueue<int[]> maxHeapByFrequency = new PriorityQueue<>(Comparator
                .comparingInt((int[] a) -> a[1])     // sort by frequency (index 1)
                .thenComparingInt((int[] b) -> b[0]) // Then sort by dictionary order of original character (index 0)
                .reversed()                          // Reversed for MaxHeap (since minHeap is default)
        );

        // For each character, add its pair [CHARACTER, FREQUENCY] into the max heap
        for (Integer charAsInt : characterFrequency.keySet()) {
            maxHeapByFrequency.add(new int[]{charAsInt, characterFrequency.get(charAsInt)});
        }

        char[] charsSortedByFreq = new char[characterFrequency.size()];
        for (int i = 0; i < characterFrequency.size(); i++) {
            // remove the next most frequent character from the max heap.
            int[] nextMostFrequent = maxHeapByFrequency.remove();
            charsSortedByFreq[i] = (char) nextMostFrequent[0]; // cast Integer back to char
        }
        return charsSortedByFreq;

        // It would have been more efficient to just sort the 2d Integer[][] array.
        // Building and slowing deconstructing the heap was suboptimal.
    }

    public static void main(String[] args) {
        QuestionTwo sol = new QuestionTwo();
        System.out.println(Arrays.toString(sol.charactersSortedByFrequency(
                "open sesame"
        )));
    }
}

class QuestionThree {
    // Special Trie with one child. Effectively a linked list
    class TrieNodeWithOneChild {
        TrieNodeWithOneChild childNode;
        Character childCharacter;
        public TrieNodeWithOneChild() {}
        public TrieNodeWithOneChild(Character c) {this.childCharacter = c;}
    }

    public String longestCommonPrefix(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        } else if (words.length == 1) {
            return words[0];
        }

        // Insert first word into the Trie with no restrictions
        TrieNodeWithOneChild root = new TrieNodeWithOneChild(); // "sentinel"/dummy node
        String firstWord = words[0];
        TrieNodeWithOneChild currNode = root;
        for (char c : firstWord.toCharArray()){
            currNode.childNode = new TrieNodeWithOneChild(c);
            currNode = currNode.childNode;
        }

        // SOLUTION: Iterate over the remaining words.
        // Use the Trie structure to keep track of the common prefix.
        // Once a character differs from the Trie, trim the Trie below and stop.
        for (int i = 1; i < words.length; i++) {
            currNode = root;
            String currWord = words[i];

            for (char c : currWord.toCharArray()) {
                if (currNode.childNode != null
                        && currNode.childNode.childCharacter == c) {
                    currNode = currNode.childNode;
                } else {
                    break; // This string and the trie differ, stop iterating.
                }
            }

            // Remove all nodes below. They are no longer "common prefix" characters.
            currNode.childNode = null;
        }

        StringBuilder longestPrefixBuilder = new StringBuilder();
        currNode = root;
        while (currNode.childNode != null) {
            currNode = currNode.childNode;
            longestPrefixBuilder.append(currNode.childCharacter);
        }
        String longestPrefix = longestPrefixBuilder.toString();
        return longestPrefix;
    }

    /**
     * NOTE: The commented solution below has the same worst-case complexity, but better average/best.
     * This week was about "Trie", so I kept the Trie solution above for edification
     */
//    public String longestCommonPrefix(String[] words) {
//        StringBuilder longestPrefixBuilder = new StringBuilder();
//
//        String firstString = words[0];
//        OUTER_LOOP:
//        for (int i = 0; i < firstString.length(); i++) {
//            char expectedChar = firstString.charAt(i);
//
//            for (String word : words) {
//                if (word.length() <= i || word.charAt(i) != expectedChar) {
//                    break OUTER_LOOP;
//                }
//            }
//
//            // If we reached here, every string in the list shared the same i-th character
//            longestPrefixBuilder.append(expectedChar);
//        }
//        String ans = longestPrefixBuilder.toString();
//        return ans;
//    }

}

class QuestionFour {
    /**
     * Special Trie with an additional field.
     * This additional field tracks the number of words
     * that use this node/"path" in the Trie.
     */
    class TrieNodeWithWordOccurrence {
        int numberOfWordsThatUseThisNode = 0; // non-standard trie field
        Map<Character, TrieNodeWithWordOccurrence> children; // array-backed would have been faster, but unknown domain

        public TrieNodeWithWordOccurrence() { children = new HashMap<>(); }

        public TrieNodeWithWordOccurrence get(Character c) { return children.get(c);}
        public void put(Character c) { children.put(c, new TrieNodeWithWordOccurrence());}
        public boolean containsKey(Character c) { return children.containsKey(c);}
    }

    /**
     * Return the shortest unique prefix for each word in words.
     * <p>
     * Build a Trie and traverse the Trie for each word. Once we land on
     * a node/"path" down the trie that is unique, that is the answer.
     * </p>
     * NOTE: words in String[] words must be unique.
     * There is no UNIQUE prefix between the same two strings ("bird" and "bird")
     */
    public String[] getShortestUniquePrefix(String[] words) {
        TrieNodeWithWordOccurrence root = new TrieNodeWithWordOccurrence();
        buildTrie(root, words); // Build the Trie data structure with the words in words[]

        int n = words.length;
        String[] shortestUniquePrefixes = new String[n];

        WORD_LOOP: // For each word in words, find the answer and store it in shortestUniquePrefixes[]
        for (int wordIndex = 0; wordIndex < n; wordIndex++) {
            String currWord = words[wordIndex];
            TrieNodeWithWordOccurrence currNode = root;

            for (int i = 0; i < currWord.length(); i++) {
                currNode = currNode.get(currWord.charAt(i)); // NOTE: charAt(i) is guaranteed to be in the Trie

                // If no other words use this currNode, this is the shortest unique prefix
                if (currNode.numberOfWordsThatUseThisNode == 1) {
                    shortestUniquePrefixes[wordIndex] = currWord.substring(0, i + 1);
                    continue WORD_LOOP;
                }
            }

            // If we reached here, this entire currWord word is contained in another word.
            // Since words in words[] must be unique, currWord is the shortest unique prefix of currWord.
            shortestUniquePrefixes[wordIndex] = currWord;
        }
        return shortestUniquePrefixes;
    }

    // Build the Special Trie data structure using the words in dictionary[]
    private void buildTrie(TrieNodeWithWordOccurrence root, String[] dictionary) {
        for (String word : dictionary) {
            TrieNodeWithWordOccurrence currNode = root;
            currNode.numberOfWordsThatUseThisNode++; // every word trivially uses the root

            for (char c : word.toCharArray()) {
                if (!currNode.containsKey(c)) {
                    currNode.put(c);
                }
                currNode = currNode.get(c);
                currNode.numberOfWordsThatUseThisNode++; // Keep track of how many words use this node
            }
        }
    }
}
