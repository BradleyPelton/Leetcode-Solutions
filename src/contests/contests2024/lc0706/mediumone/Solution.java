package contests.contests2024.lc0706.mediumone;

import java.util.ArrayList;
import java.util.List;

// Accepted after 7 minutes
// Brute forced it. Probably could have used backtracking, but this was faster.

class Solution {
    public List<String> validStrings(int n) {
        List<StringBuilder> ansBuilder = new ArrayList<>();
        ansBuilder.add(new StringBuilder("0"));
        ansBuilder.add(new StringBuilder("1"));

        for (int i = 0; i < n - 1; i++) {
            List<StringBuilder> nextSet = new ArrayList<>();

            for (StringBuilder currString : ansBuilder) {
                nextSet.add(new StringBuilder(currString).append("1"));
                if (currString.charAt(currString.length() - 1) == '1') {
                    nextSet.add(new StringBuilder(currString).append("0"));
                }
            }

            ansBuilder = nextSet;
        }

        List<String> ans = new ArrayList<>();
        for (StringBuilder sb : ansBuilder) {
            ans.add(sb.toString());
        }

        //System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.validStrings(3);
        sol.validStrings(1);




    }
}
