package contests.contests2024.lc0203.mediumone;

import java.util.ArrayDeque;


// Accepted first try
// Accepted after 16 minutes. Hideous solution
// it does run.

class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int numberOfOperations = 0;
        String currWord = word;
        while (!currWord.isEmpty()) {
            numberOfOperations++;
            if (currWord.length() < k) { // out of characters
                return (int) Math.ceil((word.length() + 0.0) / k);
            }
            currWord = currWord.substring(k);
            if (word.startsWith(currWord)) {
                return numberOfOperations;
            }
        }
        throw new IllegalStateException("finished without returning");
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumTimeToInitialState(
                "abacaba",
                3
        );
        sol.minimumTimeToInitialState(
                "abacaba",
                4
        );
        sol.minimumTimeToInitialState(
                "abcbabcd",
                2
        );








    }
}