package contests.contests2024.lc0928biweekly.mediumtwo;

import java.util.Arrays;

class Solution {
    String word1;
    String word2;
    int word1Length;
    int word2Length;
    public int[] validSequence(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        word1Length = word1.length();
        word2Length = word2.length();


        int[] smallestArray = new int[word2Length];
        Arrays.fill(smallestArray, Integer.MAX_VALUE);

        int[] solvedLetters = new int[word2Length];
        int currentWord1Index = 0;
        OUTER_LOOP:
        for (int i = 0; i < word2Length; i++) {
            // Use i as the "change index"

            // STEP ONE: Solve previousCharacter
            if (i != 0) {
                int prevCharAnswer = firstCharacter(currentWord1Index, i - 1);
                if (prevCharAnswer == -1) {
                    break;
                }
                solvedLetters[i - 1] = prevCharAnswer;
                currentWord1Index = prevCharAnswer + 1;
            }

            if (solvedLetters[i] > smallestArray[i]) { // NO POINT IN CONTINUING: local ans is always larger
                break;
            }

            // STEP 1.5: Use the "mulligan" for "i"
            currentWord1Index = currentWord1Index + 1;


            // STEP TWO: Solve remaining
            int[] remainingChars = solveRest(currentWord1Index, i + 1);
            if (remainingChars[0] == -1) {
                continue OUTER_LOOP;
            }

            for (int j = 0; j < remainingChars.length; j++) {
                if (remainingChars[j] > smallestArray[i + j]) {
                    continue OUTER_LOOP;
                }
            }

            // IF WE REACHED HERE, localAns is better
            smallestArray = new int[word2Length];
            for (int j = 0; j < i; j++) {
                smallestArray[j] = solvedLetters[j];
            }
            for (int j = 0; j < remainingChars.length; j++) {
                smallestArray[i + j] = remainingChars[j];
            }
        }

        if (smallestArray[0] == Integer.MAX_VALUE) {
            System.out.println("{}");
            return new int[0];
        } else {
            System.out.println(Arrays.toString(smallestArray));
            return smallestArray;
        }
    }

    private int firstCharacter(int word1Index, int word2Index) {
        for (int i = word1Index; i < word1Length; i++) {
            if (word1.charAt(i) == word2.charAt(word2Index)) {
                return i;
            }
        }
        return -1;
    }

    private int[] solveRest(int word1Index, int word2Index) {
        int[] ans = new int[word2Length - word2Index + 1];
        int currWord1Index = word1Index;
        OUTER_LOOP:
        for (int i = word2Index; i < word2Length; i++) {
            char targetChar = word2.charAt(i);
            for (int j = currWord1Index; j < word1Length; j++) {
                if (word1.charAt(j) == targetChar) {
                    ans[i - word2Index] = j;
                    currWord1Index = j + 1;
                    continue OUTER_LOOP;
                }
            }
            // IF WE REACHED HERE, NO SOLUTION:
            ans[0] = -1;
            break;
        }
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.validSequence(
//                "vbcca",
//                "abc"
//        );
        sol.validSequence(
                "bacdc",
                "abc"
        );
        sol.validSequence(
                "aaaaaa",
                "aaabc"
        );
        sol.validSequence(
                "abc",
                "ab"
        );



    }
}