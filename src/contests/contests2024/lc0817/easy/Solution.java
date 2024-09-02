package contests.contests2024.lc0817.easy;

// Accepted after 7 minutes
// Trivial. missed an index.

class Solution {
    public int countKConstraintSubstrings(String s, int k) {

        int numberOfGoodSubArrays = 0;
        int n = s.length();
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int numberOfOnes = 0;
                int numberOfZeroes = 0;
                for (int i = left; i <= right; i++) {
                    if (s.charAt(i) == '0') {
                        numberOfZeroes++;
                    } else {
                        numberOfOnes++;
                    }
                }
                if (numberOfZeroes <= k || numberOfOnes <= k) {
                    numberOfGoodSubArrays++;
                }
            }

        }
        System.out.println(numberOfGoodSubArrays);
        return numberOfGoodSubArrays;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countKConstraintSubstrings(
                "10101",
                1
        );
        sol.countKConstraintSubstrings(
                "1010101",
                2
        );
        sol.countKConstraintSubstrings(
                "11111",
                1
        );


    }
}
