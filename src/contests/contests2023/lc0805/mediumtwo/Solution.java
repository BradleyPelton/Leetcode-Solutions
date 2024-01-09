package contests.contests2023.lc0805.mediumtwo;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int[][] safetyGrid = new int[n][n];

        List<int[]> thiefPositions = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    thiefPositions.add(new int[]{i,j});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // calculate safety factor

                int[] currPoint = {i, j};

                int minSafety = Integer.MAX_VALUE;
                for (int[] thief : thiefPositions) {
                    int distanceToThief = getDistance(thief, currPoint);
                    minSafety = Math.min(minSafety, distanceToThief);
                }

                safetyGrid[i][j] = minSafety;
            }
        }

        return -42;
    }

    private int getDistance(int[] pointA, int[] pointB) {
        return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}