package contests.contests2024.lc0928biweekly.mediumone;

import java.util.Arrays;

// Accepted after 8 minutes
// Accepted first try

// Simply greedy problem. Don't know why this is a 5 point.

class Solution {
    public long maximumTotalSum(int[] maximumHeight) {

        Arrays.sort(maximumHeight);
        long ans = 0L;

        int n = maximumHeight.length;
        int prevVal = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int localMax = maximumHeight[i];
            int bestVal = prevVal - 1;

            if (bestVal <= 0) {
                ans = -1L;
                break;
            }

            int localVal = Math.min(localMax, bestVal);
            ans += localVal;
            prevVal = localVal;
        }

        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumTotalSum(
                new int[]{2,3,4,3}
        );
        sol.maximumTotalSum(
                new int[]{15,10}
        );
        sol.maximumTotalSum(
                new int[]{2,2,1}
        );




    }
}
