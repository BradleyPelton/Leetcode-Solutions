package contests.contests2024.lc0316.mediumone;

import java.util.ArrayList;
import java.util.List;

// Accepted after 8
// Deceptively simple.


// Optimized after the fact. O(n). Completely trivial after I thought about it.

class Solution {
    public long countSubstrings(String s, char c) {
        long ans = 0;
        long seenBefore = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                seenBefore++;
                ans += seenBefore;
            }
        }
        //System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countSubstrings(
                "abada",
                'a'
        );
        sol.countSubstrings(
                "zzz",
                'z'
        );




    }
}