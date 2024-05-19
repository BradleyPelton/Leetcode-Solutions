package contests.contests2024.lc0511.mediumone;

// Accepted after 5 minutes
// Cool problem. Simplest possible DP probably?
//


class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp  = new int[n];

        int ans = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            int localAns = energy[i];
            if (i + k < n) {
                localAns += dp[i + k];
            }

            dp[i] = localAns;
            ans = Math.max(ans, localAns);
        }

        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumEnergy(
                new int[]{5,2,-10,-5,1},
                3
        );
        sol.maximumEnergy(
                new int[]{-2,-3,-1},
                2
        );





    }
}