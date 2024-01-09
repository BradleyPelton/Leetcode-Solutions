package contests.contests2023.lc1028biweekly.mediumone;

import java.util.ArrayList;
import java.util.List;


// Accepted first attempt
// Interesting, did not expect my greedy solution to work.

class Solution {
    public int minChanges(String s) {
        List<String> splitSubstrings = new ArrayList<>();
        StringBuilder currentSubString = new StringBuilder();
        char currentSubStringChar = 9;
        for (char c : s.toCharArray()) {
            if (currentSubString.length() == 0) {
                currentSubStringChar = c;
                currentSubString.append(c);
            } else {
                if (c != currentSubStringChar) {
                    splitSubstrings.add(currentSubString.toString());
                    currentSubString = new StringBuilder();
                    currentSubString.append(c);
                    currentSubStringChar = c;
                } else {
                    currentSubString.append(c);
                }
            }
        }
        if (currentSubString.length() != 0) {
            splitSubstrings.add(currentSubString.toString());
        }


        int numberOfFlips = 0;
        for (int i = 0; i < splitSubstrings.size(); i++) {
            String subString = splitSubstrings.get(i);
            if (isStringBeautiful(subString)) {
                continue;
            } else { // ELSE ODD LENGTH
                if (i == splitSubstrings.size() - 1) {
                    // THEORY - Last substring must be of even length.
                    // Proof - All substrings to the left are even length
                    if (!isStringBeautiful(subString)) {
                        numberOfFlips++; // one flip at most
                    }
                } else {
                    String nextSubString = splitSubstrings.get(i + 1);
                    numberOfFlips++;
                    splitSubstrings.set(i + 1, nextSubString + nextSubString.charAt(0));
                }
            }
        }

        System.out.println(numberOfFlips);
        return numberOfFlips;

    }

    private boolean isStringBeautiful(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int zeroIndex = s.indexOf('0');
        int oneIndex = s.indexOf('1');
        if (zeroIndex != -1 && oneIndex != -1) {
            return false;
        }
        return true;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minChanges("1001");
        sol.minChanges("10");
        sol.minChanges("0000");
        sol.minChanges("101010101010101010101010101");
    }
}