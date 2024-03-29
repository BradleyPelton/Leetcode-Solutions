package contests.contests2024.lc0323.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Accepted after 6 minutes
// Lengthy easy problem. Brute force simplifies the problem.

// Optimal solution is a sliding window. Sliding window would have taken a long time to code.
// Even after the contest, doing the sliding window approach seems tedious.

class Solution {
    public int maximumLengthSubstring(String s) {

        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        int maxLength = 0;

        OUTER_LOOP:
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> occMap = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char nextCHar = s.charAt(j);
                int currOcc = occMap.getOrDefault(nextCHar, 0);
                if (currOcc <= 1) {
                    occMap.put(nextCHar, currOcc + 1);
                } else {
                    continue OUTER_LOOP;
                }

                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        System.out.println(maxLength);
        return maxLength;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumLengthSubstring("bcbbbcba");
        sol.maximumLengthSubstring("aaaa");




    }
}