package contests.contests2024.lc0921.hardone;

import java.util.HashMap;
import java.util.Map;

// Accepted at 10:36
// Accepted first try

// Simple sliding window

class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n = word1.length();

        int[] neededChars = new int[26];
        for (char c : word2.toCharArray()) {
            neededChars[c - 'a']++;
        }

        long ans = 0;
        int left = 0;
        int right = left - 1;

        OUTER_LOOP:
        while (left < n) {
            while (moreCharsNeeded(neededChars)) {
                right++;
                if (right >= n) {
                    break OUTER_LOOP;
                }
                neededChars[word1.charAt(right) - 'a']--;
            }


            long localAns = n - right;
            ans += localAns;

            neededChars[word1.charAt(left) - 'a']++; // LOSING CHAR
            left++;
        }

        System.out.println(ans);
        return ans;
    }

    private boolean moreCharsNeeded(int[] arr) {
        for (int val : arr) {
            if (val > 0) {
                return true;
            }
        }
        return false;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.validSubstringCount(
                "bcca",
                "abc"
        ); // 1
        sol.validSubstringCount(
                "abcabc",
                "abc"
        ); // 10
        sol.validSubstringCount(
                "abcabc",
                "aaabc"
        ); // 0



    }
}