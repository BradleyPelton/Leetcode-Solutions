package contests.contests2024.lc1026biweekly.easy;

// Accepted after 3 minutes
// Trivial

class Solution {
    public int possibleStringCount(String word) {

        int ans = 1; // NO CHANGES

        char prevChar = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (currChar == prevChar) {
                ans++;
            }
            prevChar = currChar;
        }

        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.possibleStringCount("abbcccc");
        sol.possibleStringCount("abcd");
        sol.possibleStringCount("aaaa");



    }
}
