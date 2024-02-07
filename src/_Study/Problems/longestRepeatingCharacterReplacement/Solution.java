package _Study.Problems.longestRepeatingCharacterReplacement;


import java.util.HashSet;
import java.util.Set;

/**
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/description
 *
 *
 */
class Solution {
    public int characterReplacement(String s, int k) { // Sliding Window - 47% runtime, 40% memory
        Set<Character> seenChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            seenChars.add(c);
        }
        int n = s.length();

        // 26 sliding windows - not optimal
        int maxWindowSize = 1;
        for(char targetChar : seenChars) {
            int left = 0;
            int numberOfReplacements = 0;
            for (int right = 0; right < n; right++) {
                if (s.charAt(right) != targetChar) {
                    numberOfReplacements++;
                    while (numberOfReplacements > k && left <= right) {
                        if (s.charAt(left) != targetChar) {
                            numberOfReplacements--;
                        }
                        left++;
                    }
                }
                maxWindowSize = Math.max(maxWindowSize, right - left + 1);
            }
        }
        return maxWindowSize;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.characterReplacement(
                "ABAB",
                2
        ); // 4
        sol.characterReplacement(
                "AABABBA",
                1
        ); // 4
        sol.characterReplacement(
                "ABAA",
                0
        ); // 2
    }
}