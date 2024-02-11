package contests.contests2024.lc0210.mediumtwo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Accepted after 33 miuntes
// Accepted second attempt
// Greedy Solution
// Hell of a problem. Lots of edge cases. Cool problem though.
// 100+ lines of code.

class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        Map<Integer, Integer> charOcc = new HashMap<>();
        Map<Integer, Integer> wordLengthOcc = new HashMap<>();

        for (String word : words) {
            wordLengthOcc.put(word.length(), wordLengthOcc.getOrDefault(word.length(), 0) + 1);
            for (char c : word.toCharArray()) {
                charOcc.put(c - 'a', charOcc.getOrDefault(c - 'a', 0) + 1);
            }
        }

        TreeMap<Integer, Integer> evenOcc = new TreeMap<>();
        TreeMap<Integer, Integer> oddOcc = new TreeMap<>();
        TreeMap<Integer, Integer> oneOcc = new TreeMap<>();

        for (int key : charOcc.keySet()) {
            int occVal = charOcc.get(key);
            if (occVal == 1) {
                oneOcc.put(key, 1);
            } else if (charOcc.get(key) % 2 == 0) {
                evenOcc.put(key, charOcc.get(key));
            } else {
                oddOcc.put(key, charOcc.get(key));
            }
        }

        int numberOfPalindromes = 0;
        OUTER_LOOP:
        for (int wordLength = 1; wordLength <= 101; wordLength++) {
            if (!wordLengthOcc.containsKey(wordLength)) {
                continue;
            }
            int numberOfWords = wordLengthOcc.get(wordLength);

            for (int i = 0; i < numberOfWords; i++) {
                int charsNeeded = wordLength;
                // HANDLE FIRST LETTER
                if (wordLength % 2 == 1) {
                    charsNeeded--;
                    if (!oneOcc.isEmpty()) {
                        int firstKey = oneOcc.firstKey();
                        oneOcc.remove(firstKey);
                    } else if (!oddOcc.isEmpty()) {
                        int firstKey = oddOcc.firstKey();
                        int firstOcc = oddOcc.get(firstKey);

                        oddOcc.remove(firstKey);
                        evenOcc.put(firstKey, firstOcc - 1);
                    } else {
                        if (evenOcc.isEmpty()) {
                            System.out.println("OUT OF LETTERS");
                            break OUTER_LOOP;
                        } else {
                            int firstKey = evenOcc.firstKey();
                            int firstOcc = evenOcc.get(firstKey);

                            evenOcc.remove(firstKey);
                            oddOcc.put(firstKey, firstOcc - 1);
                        }
                    }
                }

                // NOW WE HAVE AN EVEN LENGTH REQUIREMENT
                // CONSUME ALL EVEN OCCS
                CHAR_NEEDED_LOOP:
                while (charsNeeded > 0) {
                    // CONSUME ALL EVEN
                    if (!evenOcc.isEmpty()) {
                        for (int key : evenOcc.keySet()) {
                            int keyOcc = evenOcc.get(key);
                            if (keyOcc > charsNeeded) {
                                int remainingOcc = keyOcc - charsNeeded;
                                evenOcc.put(key, remainingOcc);
                                charsNeeded = 0;
                            } else if (keyOcc == charsNeeded) {
                                charsNeeded = 0;
                                evenOcc.remove(key);
                            } else {
                                evenOcc.remove(key);
                                charsNeeded -= keyOcc;
                            }
                            continue CHAR_NEEDED_LOOP;
                        }
                    } else if (!oddOcc.isEmpty()){
                        for (int key : oddOcc.keySet()) {
                            int keyOcc = oddOcc.get(key);
                            if (keyOcc > charsNeeded) {
                                int remainingOcc = keyOcc - charsNeeded;
                                if (remainingOcc == 1) {
                                    oddOcc.remove(key);
                                    oneOcc.put (key, 1);
                                } else {
                                    oddOcc.put(key, remainingOcc);
                                }
                                charsNeeded = 0;
                            } else if (keyOcc == charsNeeded) {
                                charsNeeded = 0;
                                oddOcc.remove(key);
                            } else {
                                int numberOfCharsConsumed = keyOcc - 1;
                                oddOcc.remove(key);
                                oneOcc.put(key, 1);
                                charsNeeded -= numberOfCharsConsumed;
                            }
                            continue CHAR_NEEDED_LOOP;
                        }
                    } else {
                        System.out.println("OUT OF CHARACTERS");
                        break OUTER_LOOP;
                    }
                }
                numberOfPalindromes++;
            }
            
        }

        System.out.println(numberOfPalindromes);
        return numberOfPalindromes;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxPalindromesAfterOperations(
                new String[]{"abbb","ba","aa"}
        ); // 3
        sol.maxPalindromesAfterOperations(
                new String[]{"abc","ab"}
        ); // 2
        sol.maxPalindromesAfterOperations(
                new String[]{"cd","ef","a"}
        ); // 1
        sol.maxPalindromesAfterOperations(
                new String[]{"aagha","bc"}
        ); // 1


    }
}
