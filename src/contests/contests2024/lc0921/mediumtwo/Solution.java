package contests.contests2024.lc0921.mediumtwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Accepted at 10:22
// Accepted first try

// I was surprised this did not time out.
// 26 different prefix arrays lol

// EDIT: Resubmitted solution for hardOne
//       hardOne solution was much optimized.

class Solution {
//    public long validSubstringCount(String word1, String word2) {
//        int n = word1.length();
//        int[][] prefix = new int[26][n];
//        int firstCharInt = word1.charAt(0) - 'a';
//        prefix[firstCharInt][0] = 1;
//
//        for (int i = 1; i < n; i++) {
//            int charInt = word1.charAt(i) - 'a';
//            for (int j = 0; j < 26; j++) {
//                if (j == charInt) {
//                    prefix[j][i] = prefix[j][i - 1] + 1;
//                } else {
//                    prefix[j][i] = prefix[j][i - 1];
//                }
//            }
//        }
//
//
//        Map<Character, Integer> neededCharOccMap = new HashMap<>();
//        for (char c : word2.toCharArray()) {
//            neededCharOccMap.put(c, neededCharOccMap.getOrDefault(c, 0) + 1);
//        }
//
//        long ans = 0;
//        for (int left = 0; left < n; left++) {
//            // Find the first index , right, where isValidSubstring
//            int right = Integer.MIN_VALUE;
//
//            for (char neededChar : neededCharOccMap.keySet()) {
//                int neededCharInt = neededChar - 'a';
//                int neededOcc = neededCharOccMap.get(neededChar);
//
//                int occBefore = left > 0 ? prefix[neededCharInt][left - 1] : 0;
//                int targetOcc = neededOcc + occBefore;
//
//                int localRight = binarySearchLeftMost(prefix[neededCharInt], targetOcc);
//                if (localRight < 0 || localRight >= n) {
//                    right = Integer.MAX_VALUE;
//                    break;
//                }
//
//                right = Math.max(right, localRight);
//            }
//
//            if (right == Integer.MAX_VALUE) { // No longer any valid substrings left
//                break;
//            }
//
//
//            long localAns = n - right;
//            ans += localAns;
//        }
//
//        System.out.println(ans);
//        return ans;
//    }
//
//    private int binarySearchLeftMost(int[] arr, int target) {
//        // Leetcode template code from cheatsheet
//        int left = 0;
//        int right = arr.length;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] >= target) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }

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
