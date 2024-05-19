package contests.contests2024.lc0511.easy;

// Accepted after 2 minutes
// Trivial

class Solution {
    public int findPermutationDifference(String s, String t) {


        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int tIndex = t.indexOf(String.valueOf(s.charAt(i)));
            ans += Math.abs(i - tIndex);
        }
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findPermutationDifference(
                "abc",
                "bac"
        );
        sol.findPermutationDifference(
                "abcde",
                "edbac"
        );




    }
}