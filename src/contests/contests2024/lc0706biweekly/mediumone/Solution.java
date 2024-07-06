package contests.contests2024.lc0706biweekly.mediumone;

import java.util.Arrays;

// Accepted after 15 minutes
// Two wrong asnwers. Sloppy edge case handling
// just sloppy. Nothing advanced.
// Wasted 5 minutes debugging the use of the wrong variable name.

class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        int n = enemyEnergies.length;
        long ans = 0;
        long currEnergy = currentEnergy;

        Arrays.sort(enemyEnergies);
        int smallestEnergy = enemyEnergies[0];

        if (currEnergy < smallestEnergy) {
            System.out.println(0);
            return 0;
        }

        int right = n - 1;
        while (right >= 0) {
            int numberOfPointsGained = (int) Math.floor((currEnergy + 0.0) / smallestEnergy);
            currEnergy -= (numberOfPointsGained * smallestEnergy);
            ans += numberOfPointsGained;


            currEnergy += enemyEnergies[right];
            right--;
        }


        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol =  new Solution();
        sol.maximumPoints(
                new int[]{3,2,2},
                2
        );
        sol.maximumPoints(
                new int[]{2},
                10
        );
        sol.maximumPoints(
                new int[]{2,3,4},
                4
        ); // 5
        sol.maximumPoints(
                new int[]{1,2,3},
                0
        ); // 0



    }
}
