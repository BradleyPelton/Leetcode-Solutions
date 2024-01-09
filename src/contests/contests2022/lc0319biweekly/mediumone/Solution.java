package contests.contests2022.lc0319biweekly.mediumone;

import java.util.HashMap;
import java.util.Map;

// first attempt rejected, wrong answer, hidden testcase
// second attempt rejected, wrong answer, hidden testcase
// Frustrating hidden testcase. Switching problems

class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        // Pattern ab is maximized when all a's occur before all b's

        char firstChar = pattern.charAt(0);
        char secondChar = pattern.charAt(1);

        if (text.length() == 0) {
            System.out.println("zero edge case");
            return 0;
        } else if (text.length() == 1) {
            if (text.charAt(0) == firstChar || text.charAt(0) == secondChar) {
                System.out.println("length1 valid");
                return 1;
            } else {
                System.out.println("length1 invalid");
                return 0;
            }
        }

        int totalSecondCharCount = 0;
        for (char c : text.toCharArray()) {
            if (c == secondChar) {
                totalSecondCharCount++;
            }
        }

        Map<Integer, Integer> numberOfSecondCharsAfterThisIndex = new HashMap<>();
        int secondCharsRemaining = totalSecondCharCount;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == secondChar) {
                secondCharsRemaining--;
            }
            numberOfSecondCharsAfterThisIndex.put(i, secondCharsRemaining);
        }


        // SCENARIO ONE:
        // Add firstChar to beginning of text
//        String beforeString = pattern.charAt(0) + text;
        int firstPatternAnswer = totalSecondCharCount;  // EVERY SECONCHAR GENERATES EXACTLY +1
        for (int i = 0; i < text.length(); i++) {       // COUNT as if normal
            if (text.charAt(i) == firstChar) {
                int secondCount = numberOfSecondCharsAfterThisIndex.get(i);
                firstPatternAnswer += secondCount;
            }
        }

        // SCENARIO TWO:
        // Add secondChar to end of text
//        String afterString =  text + pattern.charAt(1);
        int secondPatternAnswer = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == firstChar) {
                int secondCount = numberOfSecondCharsAfterThisIndex.get(i);
                secondPatternAnswer += (secondCount+1);  // extra secondChar means +1
            }
        }

        System.out.println("firstPatternAnswer = " + firstPatternAnswer);
        System.out.println("secondPatternAnswer = " + secondPatternAnswer);

        int ans = Math.max(firstPatternAnswer, secondPatternAnswer);
        System.out.println("final ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.maximumSubsequenceCount("abdcdbc", "ac");
//        sol.maximumSubsequenceCount("aabb", "ab");

        // tricksy
        sol.maximumSubsequenceCount("ba", "ab");



        // PARTIAL TEST CASES
//        sol.maximumSubsequenceCount("aahbb", "ch");  // expecting 1
//        sol.maximumSubsequenceCount("aacbb", "ch");  // expceting 1


        // NO MATCHES CASES
//        sol.maximumSubsequenceCount("ytjhsrtgs", "ab");
//        sol.maximumSubsequenceCount("c", "ab");

    }
}