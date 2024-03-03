package contests.contests2024.lc0302.mediumtwo;

import java.util.HashMap;
import java.util.Map;

// Accepted after 21 minutes
// Tedious, but easy.
// Accepted first attempt. Had to debug indicies for 10 minutes.

class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;

        Map<Integer, Integer> yOccMap = new HashMap<>();
        yOccMap.put(0, 0);
        yOccMap.put(1, 0);
        yOccMap.put(2, 0);
        Map<Integer, Integer> nonYOccMap = new HashMap<>();
        nonYOccMap.put(0, 0);
        nonYOccMap.put(1, 0);
        nonYOccMap.put(2, 0);

        // MAIN DIAGONAL
        int middleCoord = n  / 2;

        for (int i = 0; i <= n / 2; i++) {
            yOccMap.put(grid[i][i], yOccMap.get(grid[i][i]) + 1);
            grid[i][i] = -4;
        }

        // COUNTER DIAGONAL
        for (int i = 0; i < n / 2; i++) {
            yOccMap.put(grid[i][n - i - 1], yOccMap.get(grid[i][n - i - 1]) + 1);
            grid[i][n - i - 1] = -4;
        }
        
        // STEM
        for (int i = middleCoord + 1; i < n; i++) {
            yOccMap.put(grid[i][middleCoord], yOccMap.get(grid[i][middleCoord]) + 1);
            grid[i][middleCoord] = -4;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -4) {
                    continue;
                }
                nonYOccMap.put(grid[i][j], nonYOccMap.get(grid[i][j]) + 1);
            }
        }

        int totalYOcc = 0;
        for(int key : yOccMap.keySet()) {
            totalYOcc += yOccMap.get(key);
        }
        int totalNonYOcc = (n * n) - totalYOcc;
        
        int minNumberOfOperations = Integer.MAX_VALUE;
        for (int yVal = 0; yVal < 3; yVal++) {
            int currYValOcc = yOccMap.get(yVal);
            for (int nonYVal = 0; nonYVal < 3; nonYVal++) {
                if (yVal == nonYVal) {
                    continue;
                }
                int currNonYValOcc = nonYOccMap.get(nonYVal);

                int localAns = (totalYOcc - currYValOcc) + (totalNonYOcc - currNonYValOcc);
                minNumberOfOperations = Math.min(minNumberOfOperations, localAns);
            }
        }
        System.out.println(minNumberOfOperations);
        return minNumberOfOperations;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumOperationsToWriteY(
                new int[][]{{1,2,2},{1,1,0},{0,1,0}}
        );
        sol.minimumOperationsToWriteY(
                new int[][]{{0,1,0,1,0},{2,1,0,1,2},{2,2,2,0,1},{2,2,2,2,2},{2,1,2,2,2}}
        );



    }
}
