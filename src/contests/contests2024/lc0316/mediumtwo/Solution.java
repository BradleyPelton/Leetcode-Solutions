package contests.contests2024.lc0316.mediumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted after 20 minutes
// Cool problem. I probably way over-complicated it.
// Had to think hard about the greedy solution. Big O(uniqueChars ** 2)

// Optimized after the fact.
// Using a prefix Array and binary search, we can reduce the time complexity to lineararithmic Big O (u log u) where u = uniqueChars.
// Worst case, 26**2 is still extremely fast.

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] occ = new int[26];
        for (char c : word.toCharArray()) {
            occ[c - 'a']++;
        }

        List<Integer> occList = new ArrayList<>();
        for (int occVal : occ) {
            if (occVal != 0) {
                occList.add(occVal);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int minOcc : occList) {
            int numberOfDeletions = 0;
            for (int occVal : occList) {
                if (occVal < minOcc) {
                    numberOfDeletions += occVal;
                } else if (occVal > minOcc + k) {
                    numberOfDeletions += occVal - (minOcc + k);
                }
            }

            ans = Math.min(ans, numberOfDeletions);
        }
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumDeletions(
                "aabcaba",
                0
        );
        sol.minimumDeletions(
                "dabdcbdcdcd",
                2
        );
        sol.minimumDeletions(
                "aaabaaa",
                2
        );

    }
}