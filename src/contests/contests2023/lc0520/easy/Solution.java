package contests.contests2023.lc0520.easy;

// Accepted after 2 minutes
// Trivial.

class Solution {
    public int minLength(String s) {

        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");
            s = s.replace("CD", "");
        }

        int ans = s.length();
        System.out.println("ans = " + ans);
        return ans;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minLength("ABFCACDB");
        sol.minLength("ACBBD");
    }
}
