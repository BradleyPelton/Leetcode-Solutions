package contests.contests2024.lc0720biweekly.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted after 3 minutes
// Accepted first try
// Cool problem, kind of a brain teaser.

// If you tried to simulate this.... ooooo man

class Solution {
    public int minimumLength(String s) {

        Map<Character, Integer> occMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            occMap.put(c, occMap.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        for (char c : occMap.keySet()) {
            int localOcc = occMap.get(c);
            if (localOcc % 2 == 0) {
                ans += 2;
            } else {
                ans++;
            }
        }
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumLength("abaacbcbb");
        sol.minimumLength("aa");




    }
}