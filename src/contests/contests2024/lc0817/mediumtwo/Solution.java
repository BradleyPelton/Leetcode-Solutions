package contests.contests2024.lc0817.mediumtwo;

// Accepted at 10:18
// Accepted after third attempt


// Super confused why the DP didn't work.
// I had to change three times. TOD0 - Investigate.
// Returning the value vs storing in the DP

class Solution {

    Long[][] dp;
    int n;
    int[] energyDrinkA;
    int[] energyDrinkB;
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        this.energyDrinkA = energyDrinkA;
        this.energyDrinkB = energyDrinkB;
        n = energyDrinkA.length;
        dp = new Long[n + 1][2];

        long ansStartWithA = recurse(0, true);

        dp = new Long[n + 1][2];
        long ansStartWithB = recurse(0, false);

        long ans = Math.max(ansStartWithA, ansStartWithB);
        System.out.println(ans);
        return ans;




        // Greedy;
//        long currSum = 0;
//        boolean isA = false;



//        for (int i = 0; i < n - 1; i++) {
//
//            long localASum;
//            long localBSum;
//            if (isA) {
//                localASum = energyDrinkA[i] + energyDrinkA[i + 1];
//                localBSum = energyDrinkB[i];
//            } else {
//                localASum = energyDrinkA[i + 1];
//                localBSum = energyDrinkB[i] + energyDrinkB[i + 1];
//            }
//            if (localASum > )
//        }

    }

    public long recurse(int index, boolean prevWasA) {
        if (index >= n) {
            return 0;
        } else if (index == n - 1) {
            if (prevWasA) {
                return energyDrinkA[n - 1];
            } else {
                return energyDrinkB[n - 1];
            }
        }

        int boolIndex = prevWasA ? 0 : 1;
        if (dp[index][boolIndex] != null) {
            return dp[index][boolIndex];
        }

        // continue
        long continueGoing;
        if (prevWasA) {
            continueGoing = recurse(index + 1, true) + energyDrinkA[index];
        } else {
            continueGoing = recurse(index + 1, false) + energyDrinkB[index];
        }

        long switchDrink;
        if (prevWasA) {
            switchDrink = recurse(index + 1, false);
        } else {
            switchDrink = recurse(index + 1, true);
        }

        long ans = Math.max(continueGoing, switchDrink);
        dp[index][boolIndex] = ans;
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxEnergyBoost(
                new int[]{1,3,1},
                new int[]{3,1,1}
        );
        sol.maxEnergyBoost(
                new int[]{4,1,1},
                new int[]{1,1,3}
        );
        sol.maxEnergyBoost(
                new int[]{5,5,6,3,4,3,3,4},
                new int[]{5,3,3,4,4,6,6,3}
        ); // 35
        sol.maxEnergyBoost(
                new int[]{4,3,5,3,4,5,6,6,5},
                new int[]{5,5,4,5,6,3,3,4,3}
        ); // 42






    }
}
