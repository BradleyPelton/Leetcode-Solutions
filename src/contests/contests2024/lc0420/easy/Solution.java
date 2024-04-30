package contests.contests2024.lc0420.easy;

// Accepted, trivial

class Solution {
    public int numberOfSpecialChars(String word) {

        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (word.contains(String.valueOf(c))) {
                if (word.contains(String.valueOf(c).toUpperCase())) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfSpecialChars("aaAbcBC");
        sol.numberOfSpecialChars("abc");
        sol.numberOfSpecialChars("abBCab");



    }
}