package contests.contests2023.lc0318.mediumone;

import java.util.*;


// Spent 10 minutes debugging a stupid edge case
// Finished second attempt 8:05 pm
// 20 minutes
// cool problem. dumb edge condition (has to start at top left)

class Solution {
    public boolean checkValidGrid(int[][] grid) {

        System.out.println(Arrays.deepToString(grid));

        Map<Integer, int[]> coordMap = new HashMap<>();
        Set<int[]> uniquePoints = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int val = grid[i][j];
                coordMap.put(val, new int[]{i, j});
                uniquePoints.add(new int[]{i,j});
            }
        }
        int numberOfSquares = (int) Math.pow(grid.length, 2);

        if (uniquePoints.size() != numberOfSquares) {
            System.out.println("non unique pos");
            return false;
        }

        int[] previousCoord = coordMap.get(0);
        if (!Arrays.equals(coordMap.get(0), new int[]{0,0})) {
            System.out.println("invalid start point");
            return false;
        }
        for (int i = 1; i < numberOfSquares; i++) {
            if (!coordMap.containsKey(i)) {
                System.out.println("skipped val, i = " + i);
                return false;
            }

            int[] currCoord = coordMap.get(i);
            int xDelta = Math.abs(previousCoord[0] - currCoord[0]);
            int yDelta = Math.abs(previousCoord[1] - currCoord[1]);

            if (!(xDelta == 1 && yDelta == 2
                || xDelta == 2 && yDelta == 1)) {
                System.out.println("PROBLEM AT currCord = " + Arrays.toString(currCoord));
                return false;
            }
            previousCoord = currCoord;
        }
        System.out.println("finished with no problems");
        return true;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.checkValidGrid(
                new int[][]{{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}}
        );

        sol.checkValidGrid(
                new int[][]{{0,3,6},{5,8,1},{2,7,4}}
        );

        sol.checkValidGrid(
                new int[][]{{24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}}
        ); // expected false

    }
}