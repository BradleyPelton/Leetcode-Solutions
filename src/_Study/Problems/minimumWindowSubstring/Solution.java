package _Study.Problems.minimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring
 *
 * More of a tedious problem than any valuable lessons learned. Expand and constrict sliding window.
 */
class Solution {
    public String minWindow(String s, String t) { // Sliding Window - 69%(nice) runtime, 93% memory
        int[] tLower = new int[26];
        int[] tUpper = new int[26];
        for (char c : t.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tUpper[c - 'A']++;
            } else {
                tLower[c - 'a']++;
            }
        }

        int minWindowSize = Integer.MAX_VALUE;
        int minWindowLeft = -1;
        int minWindowRight = -1;


        int[] currLowerChars = new int[26];
        int[] currUpperChars = new int[26];

        int left = 0;
        OUTER_LOOP:
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (Character.isUpperCase(rightChar)) {
                currUpperChars[rightChar - 'A']++;
            } else {
                currLowerChars[rightChar - 'a']++;
            }

            // EXPAND RIGHT
            for (int i = 0; i < 26; i++) {
                while (tLower[i] > currLowerChars[i]) {
                    if (right == s.length() - 1) {
                        break OUTER_LOOP;
                    } else {
                        right++;
                        char nextChar = s.charAt(right);
                        if (Character.isUpperCase(nextChar)) {
                            currUpperChars[nextChar - 'A']++;
                        } else {
                            currLowerChars[nextChar - 'a']++;
                        }
                    }

                }
                while (tUpper[i] > currUpperChars[i]) {
                    if (right == s.length() - 1) {
                        break OUTER_LOOP;
                    }
                    right++;
                    char nextChar = s.charAt(right);
                    if (Character.isUpperCase(nextChar)) {
                        currUpperChars[nextChar - 'A']++;
                    } else {
                        currLowerChars[nextChar - 'a']++;
                    }
                }
            }


            // TRIM LEFT
            while (left <= right) {
                char currLeftChar = s.charAt(left);
                if (Character.isUpperCase(currLeftChar)) {
                    if (tUpper[currLeftChar - 'A'] < currUpperChars[currLeftChar - 'A']) {
                        left++;
                        currUpperChars[currLeftChar - 'A']--;
                    } else {
                        break; // currChar is at it's min Value
                    }
                } else {
                    if (tLower[currLeftChar - 'a'] < currLowerChars[currLeftChar - 'a']) {
                        left++;
                        currLowerChars[currLeftChar - 'a']--;
                    } else {
                        break; // currChar is at it's min Value
                    }
                }
            }

            int currWindowSize = right - left + 1;
            if (currWindowSize < minWindowSize) {
                minWindowLeft = left;
                minWindowRight = right;
                minWindowSize = currWindowSize;
            }
        }



        if (minWindowSize == Integer.MAX_VALUE) {
//            System.out.println("''");
            return "";
        } else {
            return s.substring(minWindowLeft, minWindowRight + 1);
//            String ans = s.substring(minWindowLeft, minWindowRight + 1);
//            System.out.println(ans);
//            return ans;
        }

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minWindow(
                "ADOBECODEBANC",
                "ABC"
        );
        sol.minWindow(
                "a",
                "a"
        );
        sol.minWindow(
                "a",
                "aa"
        );
    }
}