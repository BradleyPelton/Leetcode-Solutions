package _Study.Problems.alienDictionary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 269. Alien Dictionary
 * https://leetcode.com/problems/alien-dictionary/description/
 *
 * Long, tedious problem. Not a good learning experience after the first shot.
 *
 */
class Solution {
    Map<Integer, Set<Integer>> adjacencyList;
    int[] charInDegree;
    public String alienOrder(String[] words) { // Topological Sort - Kahn's algorithm - 30% runtime,27% memory
        charInDegree = new int[26];
        adjacencyList = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            charInDegree[c - 'a'] = -42;
            adjacencyList.put(c - 'a', new HashSet<>());
        }

        List<String> wordsAsList = new ArrayList<>();
        for (String word : words) {
            wordsAsList.add(word);
            for (char c : word.toCharArray()) {
                charInDegree[c - 'a'] = 0;
            }
        }

        for (int i = 1; i < words.length; i++) {
            String previousWord = wordsAsList.get(i - 1);
            String currWord = wordsAsList.get(i);
            if (previousWord.startsWith(currWord) && previousWord.length() > currWord.length()) {
                System.out.println("'', bad word lengths");
                return "";
            }
        }

        buildAdjacencyList(wordsAsList);



        StringBuilder ansBuilder = new StringBuilder();
        Deque<Integer> charsWithZeroInDegree = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (charInDegree[i] == 0) {
                charsWithZeroInDegree.add(i);
            }
        }

        while (!charsWithZeroInDegree.isEmpty()) {
            int currChar = charsWithZeroInDegree.remove();
            ansBuilder.append((char)(currChar + 'a'));

            for (int ch : adjacencyList.get(currChar)) {
                charInDegree[ch]--;
                if (charInDegree[ch] == 0) {
                    charsWithZeroInDegree.add(ch);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (charInDegree[i] == -42) {
                continue;
            } else {
                if (charInDegree[i] != 0) {
                    System.out.println("'', missing letter");
                    return "";
                }
            }
        }


        String ans = ansBuilder.toString();
        System.out.println(ans);
        return ans;
    }

    private void buildAdjacencyList(List<String> words) {
        if (words.size() < 2) {
            return;
        }
        List<String> wordsWithTheSameFirstLetter = new ArrayList<>();
        int previousLetter = words.get(0).charAt(0) - 'a';
        for (int i = 0; i < words.size(); i++) {
            int currLetter = words.get(i).charAt(0) - 'a';
            if (currLetter == previousLetter) {
                wordsWithTheSameFirstLetter.add(words.get(i));
            } else {

                if (wordsWithTheSameFirstLetter.size() > 1) {
                    List<String> trimmedWords = new ArrayList<>();
                    for (String word : wordsWithTheSameFirstLetter) {
                        if (word.length() > 1) {
                            trimmedWords.add(word.substring(1));
                        }
                    }
                    buildAdjacencyList(trimmedWords);
                }
                wordsWithTheSameFirstLetter = new ArrayList<>();
                wordsWithTheSameFirstLetter.add(words.get(i));



                // currLetter depends on previousLetter
                if (!adjacencyList.get(previousLetter).contains(currLetter)) {
                    charInDegree[currLetter]++;
                    adjacencyList.get(previousLetter).add(currLetter);
                }

                previousLetter = currLetter;
            }
        }

        if (wordsWithTheSameFirstLetter.size() > 1) {
            List<String> trimmedWords = new ArrayList<>();
            for (String word : wordsWithTheSameFirstLetter) {
                if (word.length() > 1) {
                    trimmedWords.add(word.substring(1));
                }
            }
            buildAdjacencyList(trimmedWords);
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}); // wertf
        sol.alienOrder(new String[]{"z", "x"}); // zx
        sol.alienOrder(new String[]{"z", "x", "z"}); // ""
        sol.alienOrder(new String[]{"zy", "zx"}); // yzx or zyx
        sol.alienOrder(new String[]{"ab", "adc"}); // abcd
        sol.alienOrder(new String[]{"z", "z"}); //
        sol.alienOrder(new String[]{"abc", "ab"}); // ""
    }
}