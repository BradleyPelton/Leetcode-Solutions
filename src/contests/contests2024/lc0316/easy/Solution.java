package contests.contests2024.lc0316.easy;

// Accepted after 3 minutes
// Trivial
// Off by one index led to a wrong answer. Rare to get an off by one with .subString()

// Optimized while procrastinating hard.

class Solution {
    public boolean isSubstringPresent(String s) {
        boolean[][] seenForward = new boolean[26][26];

        int n = s.length();
        for (int i = 0; i <= n - 2; i++) {
            seenForward[s.charAt(i) - 'a'][s.charAt(i + 1) - 'a'] = true;
        }


        for (int i = n - 1; i > 0; i--) {
            if (seenForward[s.charAt(i) - 'a'][s.charAt(i - 1) - 'a']) {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isSubstringPresent("leetcode");
        sol.isSubstringPresent("abcba");
        sol.isSubstringPresent("abcd");
        sol.isSubstringPresent("ausoee"); // true




    }
}
