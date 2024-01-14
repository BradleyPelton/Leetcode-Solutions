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
 *
 * Trivia: There is a hyper efficient (Linear Big O(n)) solution using a niche algorithm known as
 * Manacher's algorithm ( see https://en.wikipedia.org/wiki/Longest_palindromic_substring#Manacher's_algorithm )
 * Out of scope.
 */
class Solution {
    public String longestPalindromeEXPANDFROMCENTER(String s) {
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

    int n;
    Boolean[][] dp;
    public String longestPalindrome(String s) {
        n = s.length();
        dp = new Boolean[n][n];

        isPalindrome(s, 0, n - 1);
        int maxLength = -1;
        int ansI = 0;
        int ansJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // TODO - Find a more efficient way of finding the solution from boolean[][] dp;
                if (j - i + 1 > maxLength) {
                    if (isPalindrome(s, i, j)) {
                        maxLength = j - i + 1;
                        ansI = i;
                        ansJ = j;
                    }
                }
            }
        }
        String ans = s.substring(ansI, ansJ + 1);
        System.out.println(ans);
        return ans;
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left < 0 || right > n - 1) {
            return false;
        } else if (left == right) {
            return true;
        } else if (left == right - 1) {
            return s.charAt(left) == s.charAt(right);
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        boolean localAns;
        if (s.charAt(left) == s.charAt(right)) {
            localAns = isPalindrome(s, left + 1, right - 1);
        } else {
            localAns = false;
            isPalindrome(s, left + 1, right);
            isPalindrome(s, left, right - 1);
        }
        dp[left][right] = localAns;
        return localAns;
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