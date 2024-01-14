package contests.contests2024.lc0113.mediumone;

import java.util.ArrayList;
import java.util.List;

// Accepted after 9 minutes
// Cool little problem. I thought I might have to binary search to optimize, but not.

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();
        int n = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, Math.min(n, i + a.length())).equals(a)) {
                aIndices.add(i);
            }
            if (s.substring(i, Math.min(n, i + b.length())).equals(b)) {
                bIndices.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        OUTER_LOOP:
        for (int aIndex : aIndices) {
            for(int bIndex : bIndices) {
                if (Math.abs(aIndex - bIndex) <= k) {
                    ans.add(aIndex);
                    continue OUTER_LOOP;
                }
            }
        }

        //System.out.println(ans);
        return ans;
    }
}






class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.beautifulIndices(
                "isawsquirrelnearmysquirrelhouseohmy",
                "my",
                "squirrel",
                15
        );
        sol.beautifulIndices(
                "abcd",
                "a",
                "a",
                4
        );


    }
}