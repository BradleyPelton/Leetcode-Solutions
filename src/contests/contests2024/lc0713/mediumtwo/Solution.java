package contests.contests2024.lc0713.mediumtwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// First attempt TLE
// Spent 25 minutes building a DP with bitmask for TLE. What the actual fuck.

// Second attempt accepted
// Spent 10 minutes rewriting DP. There was a huge optimization that I missed.
// Was not knapsack 0-1, but rather accept largest horizontal or largest vertical

class Solution {
    int m;
    int n;
    int[] horizontalCut;
    int[] verticalCut;
    Integer[][] dp;
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        this.m = m;
        this.n = n;
        this.horizontalCut = horizontalCut;
        this.verticalCut = verticalCut;
        Arrays.sort(this.horizontalCut);
        Arrays.sort(this.verticalCut);
        dp = new Integer[m + 1][n + 1];

        int ans = topDown(m - 1, n - 1);
        System.out.println(ans);
        return ans;
    }

    private int topDown(int horizontalIndex, int verticalIndex) {
        if (horizontalIndex == 0 && verticalIndex == 0) {
            return 0;
        }

        if (dp[horizontalIndex][verticalIndex] != null) {
            return dp[horizontalIndex][verticalIndex];
        }

        int ans = Integer.MAX_VALUE;

        // horizontal
        if (horizontalIndex > 0) {
            int localCost = horizontalCut[horizontalIndex - 1] * (n - verticalIndex);
            int horizontalLocal = topDown(horizontalIndex - 1, verticalIndex) + localCost;
            ans = Math.min(ans, horizontalLocal);
        }

        if (verticalIndex > 0) {
            int localCost = verticalCut[verticalIndex - 1] * (m - horizontalIndex);
            int verticalLocal = topDown(horizontalIndex, verticalIndex - 1) + localCost;
            ans = Math.min(ans, verticalLocal);
        }

        dp[horizontalIndex][verticalIndex] = ans;
        return ans;
    }


//    int m;
//    int n;
//    int[] horizontalCut;
//    int[] verticalCut;
//    Map<Integer, Map<Integer, Integer>> dp;
//    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
//        this.m = m;
//        this.n = n;
//        this.horizontalCut = horizontalCut;
//        this.verticalCut = verticalCut;
//        dp = new HashMap<>();
//        // Backtracking
//
//        // DP with bitmask
//
//
//        int ans = topDown(0, 0, 0 , 0);
//        System.out.println(ans);
//        return ans;
//    }
//
//    private int topDown(int horizontalMap, int verticalMap, int numberOfHorizontalCuts, int numberOfVerticalCuts) {
//        if (numberOfHorizontalCuts == m - 1 && numberOfVerticalCuts == n - 1) {
//            return 0;
//        }
//
//        if (dp.containsKey(horizontalMap)) {
//            if (dp.get(horizontalMap).containsKey(verticalMap)) {
//                return dp.get(horizontalMap).get(verticalMap);
//            }
//        }
//
//        int ans = Integer.MAX_VALUE;
//
//        // VERTICAL
//        if (numberOfVerticalCuts < n - 1) {
//            for (int i = 0; i < n - 1; i++) {
//                if (!isBitSet(verticalMap, i)) {
//                    int updatedMap = verticalMap | (1 << i);
//                    int localCost = verticalCut[i] * (numberOfHorizontalCuts + 1);
//                    int localAns = topDown(
//                            horizontalMap,
//                            updatedMap,
//                            numberOfHorizontalCuts,
//                            numberOfVerticalCuts + 1
//                    ) + localCost;
//                    ans = Math.min(ans, localAns);
//                }
//            }
//        }
//
//        // HORIZONTAL
//        if (numberOfHorizontalCuts < m - 1) {
//            for (int i = 0; i < m - 1; i++) {
//                if (!isBitSet(horizontalMap, i)) {
//                    int updatedMap = horizontalMap | (1 << i);
//                    int localCost = horizontalCut[i] * (numberOfVerticalCuts + 1);
//                    int localAns = topDown(
//                            updatedMap,
//                            verticalMap,
//                            numberOfHorizontalCuts + 1,
//                            numberOfVerticalCuts
//                    ) + localCost;
//                    ans = Math.min(ans, localAns);
//                }
//            }
//        }
//
//        if (!dp.containsKey(horizontalMap)) {
//            dp.put(horizontalMap, new HashMap<>());
//        }
//        dp.get(horizontalMap).put(verticalMap, ans);
//
//
//        return ans;
//    }
//
//    private boolean isBitSet(int mask, int index) {
//        boolean isBitToggled = ((mask) & (1 << (index))) != 0;
//        return isBitToggled;
//    }
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
