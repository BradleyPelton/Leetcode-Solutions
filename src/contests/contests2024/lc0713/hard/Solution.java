package contests.contests2024.lc0713.hard;


// First Attempt, memory limit exceeded. Worth a shot resubmitting mediumtwo.

// Second attempt Accepted. Unbelievable, 7 point problem is a simple sort.
// Seems like there is something wrong with the test cases.

import java.util.Arrays;

class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {

        int numberOfHorizontalCuts = 0;
        int numberOfVerticalCuts = 0;
        Arrays.sort(horizontalCut); // mlogm  + nlogn
        Arrays.sort(verticalCut);


        int verticalIndex = n - 2;
        int horizontalIndex = m - 2;

        long ans = 0;
        while (verticalIndex >= 0 || horizontalIndex >= 0) {
            int verticalCost = verticalIndex >= 0 ? verticalCut[verticalIndex] : Integer.MIN_VALUE;
            int horizontalCost = horizontalIndex >= 0 ? horizontalCut[horizontalIndex] : Integer.MIN_VALUE;

            int localCost;
            if (verticalCost > horizontalCost) {
                localCost = verticalCost * (numberOfHorizontalCuts + 1);
                numberOfVerticalCuts++;
                verticalIndex--;
            } else {
                localCost = horizontalCost * (numberOfVerticalCuts + 1);
                numberOfHorizontalCuts++;
                horizontalIndex--;
            }
            ans += localCost;
        }

        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumCost(
                3,
                2,
                new int[]{1,3},
                new int[]{5}
        );
        sol.minimumCost(
                2,
                2,
                new int[]{7},
                new int[]{4}
        );

    }
}