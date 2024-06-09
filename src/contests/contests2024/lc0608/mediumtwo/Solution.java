package contests.contests2024.lc0608.mediumtwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// First attempt TLE
// Second attempt TLE
// Third attempt TLE

// Fourth attempt accepted
// Changed the DP type from Map<Integer, Map<Integer, Integer>> to int[][];
// Had a thought that the total sum could never exceed 2000 * 2;

// Classic Knapsack problem. (0/1)

class Solution {
    int n;
    int[] rewardValues;
    Integer[][] dp;
    public int maxTotalReward(int[] rewardValues) {
        n = rewardValues.length;
        this.rewardValues = rewardValues;
        Arrays.sort(rewardValues);
        dp = new Integer[n][4001];

        int ans = maxReward(0, 0);
        System.out.println(ans);
        return ans;
    }

    private int maxReward(int index, int currSum) {
        if (index == n) {
            return currSum;
        }
        if (dp[index][currSum] != null) {
            return dp[index][currSum];
        }

        // DO NOTHING
        int ans = maxReward(index + 1, currSum);

        // TAKE
        if (rewardValues[index] > currSum) {
            int nextSum = currSum + rewardValues[index];
            int localAns = nextSum;

            int pos = Arrays.binarySearch(rewardValues, nextSum + 1);
            if (pos < 0) {
                pos = -pos-1;
            }

            if (pos != n) {
                while (pos > 0 && rewardValues[pos] == rewardValues[pos - 1]) {
                    pos--;
                }

                localAns = maxReward(pos, nextSum);
            }
            ans = Math.max(ans, localAns);
        }
        dp[index][currSum] = ans;
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxTotalReward(
                new int[]{1,1,3,3}
        );
        sol.maxTotalReward(
                new int[]{1,6,4,3,2}
        ); // [1, 2, 3, 4, 6]





    }
}
