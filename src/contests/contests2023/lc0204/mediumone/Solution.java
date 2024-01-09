package contests.contests2023.lc0204.mediumone;

import java.util.*;

// First attempt: Time Limit Exceeded
// 2nd, 3rd, TLE

// I struggled a lot with optimization. Lost an hour on this problem.

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {

        int[] wordsVal = new int[words.length];

        // n
        int numberOfGoodWords = 0;
        for (int i = 0; i < words.length; i++) {
            char firstChar = words[i].charAt(0);
            char lastChar = words[i].charAt(words[i].length() - 1);
            if (isVowel(firstChar) && isVowel(lastChar)) {
                numberOfGoodWords++;
                wordsVal[i] = 1;
            } else {
                wordsVal[i] = 0;
            }
        }

        Map<Integer, Integer> numberOfGoodWordsBeforeIndexExclusive = new HashMap<>();
        Map<Integer, Integer> numberOfGoodWordsAfterIndexExclusive = new HashMap<>();
        int currentGoodWordCount = 0;

        // [1,0,0,1,1,0,1,0,0,1]
        for (int i = 0; i < wordsVal.length; i++) {
            numberOfGoodWordsBeforeIndexExclusive.put(i, currentGoodWordCount);
            currentGoodWordCount += wordsVal[i]; // [0,i]
            numberOfGoodWordsAfterIndexExclusive.put(i, numberOfGoodWords - currentGoodWordCount);
        }


        int[] answersToQueries = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int before = numberOfGoodWordsBeforeIndexExclusive.get(query[0]);
            int after = numberOfGoodWordsAfterIndexExclusive.get(query[1]);
            int sumOfVowelWords = numberOfGoodWords - before - after;
            answersToQueries[i] = sumOfVowelWords;
        }

//        System.out.println("ans = " + Arrays.toString(answersToQueries));
        return answersToQueries;
    }

    private boolean isVowel(Character c) {
        if (c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u') {
            return true;
        } else {
            return false;
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.vowelStrings(
                new String[]{"aba","bcb","ece","aa","e"},
                new int[][]{{0,2},{1,4},{1,1}}
        );

        sol.vowelStrings(
                new String[]{"a","e","i"},
                new int[][]{{0,2},{0,1},{2,2}}
        );
    }
}