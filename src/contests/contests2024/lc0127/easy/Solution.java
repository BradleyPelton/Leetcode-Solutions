package contests.contests2024.lc0127.easy;

import java.util.HashSet;
import java.util.Set;


// Accepted after 3 minutes
// Trivial.

class Solution {
    public int countKeyChanges(String s) {
        int ans = 0;
        int previousKey = s.charAt(0) - 'a';
        for (int i = 1; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (c != previousKey && c != previousKey + 32 && c != previousKey - 32) {
                ans++;
                previousKey = c;
            }
        }
        System.out.println(ans);
        return ans;
    }
}





class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countKeyChanges("aAbBcC");
        sol.countKeyChanges("AaAaAaaA");





    }
}