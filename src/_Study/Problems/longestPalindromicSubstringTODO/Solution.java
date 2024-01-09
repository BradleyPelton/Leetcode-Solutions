package _Study.Problems.longestPalindromicSubstringTODO;

import java.util.Arrays;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * <p>
 *     Iterative Approach: "Expand From Centers"
 * </p>
 *
 * <p>
 *     Dynamic Programming Approach:
 *     Time Complexity: Big O(n**2)
 *     Space Complexity: Big O(n**2) - We create a table of n**2 size
 *
 * </p>
 *
 * // TODO - Do the DP approach here.
 */
class Solution {
    public String longestPalindromeExpandFromCenter(String s) {
        String longestSubstring = "";

        for (int i = 0; i < s.length(); i++) {

            // ODD LENGTH PALINDROME
            StringBuilder maxSubStringBuilder = new StringBuilder();
            maxSubStringBuilder.append(s.charAt(i));
            for (int j = 1; j < s.length(); j++) {
                if (i - j < 0 || i + j > s.length() - 1) { // Out of bounds
                    break;
                }
                char leftChar = s.charAt(i - j);
                char rightChar = s.charAt(i + j);
                if (leftChar == rightChar) {
                    maxSubStringBuilder.insert(0, leftChar);
                    maxSubStringBuilder.append(rightChar);
                } else {
                    break;
                }
            }
            String maxSubstring = maxSubStringBuilder.toString();
            if (maxSubstring.length() > longestSubstring.length()) {
                longestSubstring = maxSubstring;
            }

            // EVEN - LEFT
            if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i)) {
                StringBuilder maxSubStringBuilderEVENLEFT = new StringBuilder();
                maxSubStringBuilderEVENLEFT.append(s.charAt(i));
                maxSubStringBuilderEVENLEFT.append(s.charAt(i - 1));
                int leftPointer = i - 2;
                int rightPointer = i + 1;
                for (int j = 1; j < s.length(); j++) {
                    if (leftPointer < 0 || rightPointer > s.length() - 1) { // Out of bounds
                        break;
                    }
                    char leftChar = s.charAt(leftPointer);
                    char rightChar = s.charAt(rightPointer);
                    if (leftChar == rightChar) {
                        maxSubStringBuilderEVENLEFT.insert(0, leftChar);
                        maxSubStringBuilderEVENLEFT.append(rightChar);
                        leftPointer--;
                        rightPointer++;
                    } else {
                        break;
                    }
                }
                String maxSubstringEVENLEFT = maxSubStringBuilderEVENLEFT.toString();
                if (maxSubstringEVENLEFT.length() > longestSubstring.length()) {
                    longestSubstring = maxSubstringEVENLEFT;
                }
            }
        }
        System.out.println("ans = " + longestSubstring);
        return longestSubstring;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.longestPalindrome("babad");
//        sol.longestPalindrome("cbbd");
//        sol.longestPalindrome("a");
//        sol.longestPalindrome("ccc");
//        sol.longestPalindrome("aacabdkacaa"); // expected aca
    }
}