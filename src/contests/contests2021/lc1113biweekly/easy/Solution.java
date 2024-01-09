package contests.contests2021.lc1113biweekly.easy;

import java.util.HashMap;
import java.util.Map;

// Accepted first try
// Accepted after 8 minutes

// Trivial, but long

class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {

        Map<Character, Integer> wordOneOccMap = new HashMap<>();
        Map<Character, Integer> wordTwoOccMap = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char word1Char = word1.charAt(i);
            char word2Char = word2.charAt(i);

            if(wordOneOccMap.containsKey(word1Char)) {
                int currValOne = wordOneOccMap.get(word1Char);
                wordOneOccMap.put(word1Char, currValOne+1);
            } else {
                wordOneOccMap.put(word1Char, 1);
            }

            if(wordTwoOccMap.containsKey(word2Char)) {
                int currValTwo = wordTwoOccMap.get(word2Char);
                wordTwoOccMap.put(word2Char, currValTwo+1);
            } else {
                wordTwoOccMap.put(word2Char, 1);
            }
        }

        for(Character c : wordOneOccMap.keySet()) {
//            System.out.println(c);
            int wordOneOcc = wordOneOccMap.getOrDefault(c, 0);
            int wordTwoOcc = wordTwoOccMap.getOrDefault(c, 0);

            if (Math.abs(wordOneOcc - wordTwoOcc) > 3) {
                System.out.println("problem with char = " + c);
                return false;
            }
        }

        for(Character c : wordTwoOccMap.keySet()) {
//            System.out.println(c);
            int wordOneOcc = wordOneOccMap.getOrDefault(c,0);
            int wordTwoOcc = wordTwoOccMap.getOrDefault(c,0);

            if (Math.abs(wordOneOcc - wordTwoOcc) > 3) {
                System.out.println("problem with char = " + c);
                return false;
            }
        }

        System.out.println("no problems, returning true");
        return true;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.checkAlmostEquivalent("aaaa", "bccb");
        sol.checkAlmostEquivalent("abcdeef", "abaaacc");
        sol.checkAlmostEquivalent("cccddabba", "babababab");




    }
}
