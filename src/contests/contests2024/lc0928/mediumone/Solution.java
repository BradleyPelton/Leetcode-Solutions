package contests.contests2024.lc0928.mediumone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Accepted after 10 minutes
// Brute force
// Theres probably an awesome DP solution.

class Solution {
    public int countOfSubstrings(String word, int k) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

        int n = word.length();
        int ans = 0;
        OUTER_LOOP:
        for (int i = 0; i < n; i++) {
            int[] charCount = new int[26];
            int consonantCount = 0;
            boolean vowelsAreGood = false;
            INNER_LOOP:
            for (int j = i; j < n; j++) {
                char currChar = word.charAt(j);
                if (vowels.contains(currChar)) {
                    charCount[currChar - 'a']++;
                } else {
                    consonantCount++;
                }

                if (consonantCount > k) {
                    continue OUTER_LOOP;
                } else if (consonantCount < k) {
                    continue INNER_LOOP;
                } else {
                    if (vowelsAreGood) {
                        ans++;
                    } else {
                        if (charCount['a' - 'a'] > 0
                                && charCount['e' - 'a'] > 0
                                && charCount['i' - 'a'] > 0
                                && charCount['o' - 'a'] > 0
                                && charCount['u' - 'a'] > 0) {
                            vowelsAreGood = true;
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countOfSubstrings(
                "aeioqq",
                1
        );
        sol.countOfSubstrings(
                "aeiou",
                0
        );
        sol.countOfSubstrings(
                "ieaouqqieaouqq",
                1
        );



    }
}