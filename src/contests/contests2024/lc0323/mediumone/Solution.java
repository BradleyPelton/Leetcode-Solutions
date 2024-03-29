package contests.contests2024.lc0323.mediumone;

import java.util.HashMap;
import java.util.Map;

// First attempt TLE, even with DP
// Second attempt TLE, even with DP

// Accepted after 18 minutes
// Bad habit to jump straight to DP. I completely whiffed the input parameters (k < = 10**5)

// Slight optimization after the contest.

class Solution {
    public int minOperations(int k) {
        int minNumberOfOperations = k;
        for (int denom = 1; denom <= k; denom++) {
            int baseNumber = (int) Math.ceil((k + 0.0)/denom);

            int localAns = (baseNumber - 1) + (denom - 1);
            minNumberOfOperations = Math.min(minNumberOfOperations, localAns);

            if (baseNumber == 1) { // all base numbers after 1 are also 1.
                break;
            }
        }
        //System.out.println(minNumberOfOperations);
        return minNumberOfOperations;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minOperations(11); // 5
        sol.minOperations(1); // 0


        sol.minOperations(388);
        sol.minOperations(477);




    }
}
