package contests.contests2024.lc0928.mediumtwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//

class Solution {
    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        int[][] prefix = new int[6][n];

        Map<Character, Integer> indexMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (c == 'a') {
                indexMap.put(c, 0);
            } else if (c == 'e') {
                indexMap.put(c, 1);
            } else if (c == 'i') {
                indexMap.put(c, 2);
            } else if (c == 'o') {
                indexMap.put(c, 3);
            } else if (c == 'u') {
                indexMap.put(c, 4);
            } else {
                indexMap.put(c, 5);
            }
        }

        char firstChar = word.charAt(0);
        int firstCharIndex = indexMap.get(firstChar);
        prefix[firstCharIndex][0]++;

        for (int i = 1; i < n; i++) {
            char currChar = word.charAt(i);
            int currCharIndex = indexMap.get(currChar);
            prefix[currCharIndex][i]++;

            for (int j = 0; j < 6; j++) {
                prefix[j][i] += prefix[j][i - 1];
            }
        }

        long ans = 0L;


        for (int i = 0; i < n; i++) {
            int aCountBefore = i == 0 ? 0 : prefix[0][i - 1];
            int eCountBefore = i == 0 ? 0 : prefix[1][i - 1];
            int iCountBefore = i == 0 ? 0 : prefix[2][i - 1];
            int oCountBefore = i == 0 ? 0 : prefix[3][i - 1];
            int uCountBefore = i == 0 ? 0 : prefix[4][i - 1];

            int minAIndex = binarySearchLeftMost(prefix[0], aCountBefore + 1);
            int minEIndex = binarySearchLeftMost(prefix[1], eCountBefore + 1);
            int minIIndex = binarySearchLeftMost(prefix[2], iCountBefore + 1);
            int minOIndex = binarySearchLeftMost(prefix[3], oCountBefore + 1);
            int minUIndex = binarySearchLeftMost(prefix[4], uCountBefore + 1);

            int minVowelRight = Math.max(minAIndex, Math.max(minEIndex, Math.max(minIIndex, Math.max(minOIndex, minUIndex))));

            if (minVowelRight >= n) {
                break;
            }

            int consonantCountBefore = i == 0 ? 0 : prefix[5][i - 1];

            int currNumberOfConsonant = prefix[5][minVowelRight] - consonantCountBefore;
            if (currNumberOfConsonant > k) {
                continue;
            } else if (currNumberOfConsonant == k) {
                int maxRight = binarySearchLeftMost(prefix[5], consonantCountBefore + k + 1);

                if (maxRight >= n) {
                    ans += n - minVowelRight;
                } else {
                    ans += maxRight - minVowelRight;
                }
            } else { // currNumberOfConsonant < k
                int minConsonantIndex;
                if (k == 0) {
                    minConsonantIndex = minVowelRight;
                } else {
                    minConsonantIndex = binarySearchLeftMost(prefix[5], consonantCountBefore + k);
                }
                if (minConsonantIndex >= n) { // There are not enough consonants left in the string
                    break;
                }

                int minWithBoth = Math.max(minVowelRight, minConsonantIndex);

                // WE ARRIVED AT A GOOD ARRAY HERE
                int maxConsonantIndex = binarySearchLeftMost(prefix[5], consonantCountBefore + k + 1);
                if (maxConsonantIndex >= n) {
                    ans += n - minWithBoth;
                } else {
                    ans += maxConsonantIndex - minWithBoth;
                }

            }
        }

        System.out.println(ans);
        return ans;
    }

    private int binarySearchLeftMost(int[] arr, int target) {
        if (target > arr[arr.length - 1]) {
            return Integer.MAX_VALUE;
        }
        // Leetcode template code from cheatsheet
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countOfSubstrings(
                "aeioqq",
                1
        ); // 0
        sol.countOfSubstrings(
                "aeiou",
                0
        ); // 1
        sol.countOfSubstrings(
                "ieaouqqieaouqq",
                1
        ); // 3




    }
}
