package contests.contests2023.lc0415.mediumone;

import java.util.Arrays;

// Accepted after 14 minutes
// Fumbled with indexes. Two easy problems.

class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {

        int[] uniqueDivisor = Arrays.stream(divisors).distinct().toArray();

        int maxDivisorScore = Integer.MIN_VALUE;
        int maxDivisorValue = Integer.MIN_VALUE;
        for (int i = 0; i < divisors.length; i++) {
            int divScore = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    divScore++;
                }
            }

            if (divScore == maxDivisorScore) {
                if (maxDivisorValue > divisors[i]) {
                    maxDivisorValue = divisors[i];
                }
            } else if (divScore > maxDivisorScore) {
                maxDivisorScore = divScore;
                maxDivisorValue = divisors[i];
            }
        }

        System.out.println("ans = " + maxDivisorValue);
        return maxDivisorValue;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxDivScore(
                new int[]{4,7,9,3,9},
                new int[]{5,2,3}
        );
        sol.maxDivScore(
                new int[]{20,14,21,10},
                new int[]{5,7,5}
        );
        sol.maxDivScore(
                new int[]{12},
                new int[]{10,16}
        );
        sol.maxDivScore(
                new int[]{73,13,20,6},
                new int[]{56,75,83,26,24,53,56,61}
        );// expected 24
    }
}