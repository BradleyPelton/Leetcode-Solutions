package contests.contests2023.lc0610biweekly.mediumone;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int longestSemiRepetitiveSubstring(String s) {

        char[] sAsCharArray = s.toCharArray();
        List<Integer> consecutiveIndex = new ArrayList<>();

        char previousChar = sAsCharArray[0];
        for (int i = 1; i < sAsCharArray.length; i++) {
            char newChar = sAsCharArray[i];
            if (newChar == previousChar) {
                consecutiveIndex.add(i);
            }
            previousChar = newChar;
        }


        if (consecutiveIndex.size() == 0 || consecutiveIndex.size() == 1) {
            System.out.println("trivial ans, ans = " + s.length());
            return s.length();
        }


        int longestSubArray = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int currentLength = 0;

        int firstRepetition = 0;
        int secondRepetition = 0;
        int thirdRepetition = 0;

        // 1,2,3,[[[firstRepetition,1,2,3,secondRepetition,1,2,3]]]],thirdRepetition

        // Handle beginning of string
        int secondConsecIndex = consecutiveIndex.get(1);
        int beginningLongest = secondConsecIndex; // [0 -> (secondIndex-1)]

        int secondBeforeEnd = consecutiveIndex.get(consecutiveIndex.size() - 2);
        int endLongest = (s.length()) - (secondBeforeEnd);

        longestSubArray = Math.max(beginningLongest, endLongest);

        for (int index : consecutiveIndex) {


            firstRepetition = secondRepetition;
            secondRepetition = thirdRepetition;
            thirdRepetition = index;


            // don't include the value to left of firstRepetition that makes it a repetition
            leftIndex = firstRepetition;

            // Handle last index
            rightIndex = thirdRepetition - 1;
            currentLength = rightIndex - leftIndex;
            if (currentLength > longestSubArray) {
                longestSubArray = currentLength;
            }
        }


        System.out.println("ans = " + longestSubArray);
        return longestSubArray;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestSemiRepetitiveSubstring("52233"); // expected 4
        sol.longestSemiRepetitiveSubstring("5494");  // expected 4
        sol.longestSemiRepetitiveSubstring("1111111"); // expected 2
        sol.longestSemiRepetitiveSubstring("0001"); // expected 3
        sol.longestSemiRepetitiveSubstring("14457889"); // expected 6
    }
}
