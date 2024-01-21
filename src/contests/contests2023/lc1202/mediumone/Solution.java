package contests.contests2023.lc1202.mediumone;

import java.util.ArrayList;
import java.util.List;

// First Attempt TLE
// Second Attempt TLE
// Third Attempt TLE
// Fuck this problem.

class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        // Greedy choosing the smallest doesn't work.
        // Greedy choosing the largest definitely doesn't work.

        // POWERS OF TWO
        // BINARY
        // MISSING BITS



        List<Integer> powersOfTwoLessThanTarget = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            int val = (int) Math.pow(2, i);
            if (val <= target) {
                powersOfTwoLessThanTarget.add(val);
            } else {
                break;
            }
        }

        List<Integer> coinsList = new ArrayList<>();
        for (int coin : coins) {
            coinsList.add(coin);
        }

        int ans = 0;
        for(int powerOfTwo : powersOfTwoLessThanTarget) {
            if (!coinsList.contains(powerOfTwo)) {
                ans++;

                List<Integer> newVals = new ArrayList<>();
                for (int i = 1; i < coins.length; i++) {
                    newVals.add(powerOfTwo);
                    for (int val : coinsList) {
                        if (val + powerOfTwo <= target) {
                            newVals.add(val + powerOfTwo);
                        }
                    }
                }
                coinsList.addAll(newVals);
            }
        }

        System.out.println(ans);
        return ans;


        // if we have 1,...,n , then we have
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumAddedCoins(new int[]{1,4,10}, 19);
        sol.minimumAddedCoins(new int[]{1,4,10,5,7,19}, 19);
        sol.minimumAddedCoins(new int[]{1,1,1}, 20);
        sol.minimumAddedCoins(new int[]{1}, 100000);
        sol.minimumAddedCoins(new int[]{100000}, 100000);  // 19?
    }
}