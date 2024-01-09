package contests.contests2022.lc0430.hard;

import java.util.HashMap;

// First honest attempt at a hard. Valiant attempt, but my solution had a logical error

class Solution {
    HashMap<Character, Integer> firstOcc;
    long finalCount = 0L;

    public long appealSum(String s) {

        firstOcc = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (!firstOcc.containsKey(currChar)) {
                firstOcc.put(currChar, i);
            }
        }

        recursiveCount(s);

        System.out.println("final ans = " + finalCount);
        return finalCount;
    }

    public void recursiveCount(String substring) {
        System.out.println("curr substring = " + substring);

        if (substring.length() == 1) {
            finalCount += 1;
        } else {
            int indexOfTrailingChar = substring.length() - 1;
            char trailingChar = substring.charAt(indexOfTrailingChar);
            int firstOccVal = firstOcc.get(trailingChar);

            // If this is the last occurrence of this char
            if (firstOccVal == indexOfTrailingChar) {
                // Every substring gets a plus 1 appeal
                finalCount += substring.length() - 1;
            }

            recursiveCount(substring.substring(0, substring.length() - 1));
        }

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.appealSum("abbca");
//        sol.appealSum("code");
    }
}