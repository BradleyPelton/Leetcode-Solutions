package contests.contests2023.lc0527.mediumone;

import java.util.HashSet;
import java.util.Set;

// Accepted after 12 minutes
// Tedious handling of indices

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {

        int[][] topLeft =  new int[grid.length][grid[0].length];
        int[][] bottomRight =  new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int currentI = i;
                int currentJ = j;

                // top left calculate
                Set<Integer> uniqueTopLeft = new HashSet<>();
                while (true) {
                    currentI--;
                    currentJ--;
                    if ((currentI >= 0 && currentI < grid.length) && (currentJ >= 0 && currentJ < grid[0].length)) {
                        uniqueTopLeft.add(grid[currentI][currentJ]);
                    } else {
                        break;
                    }
                }
                topLeft[i][j] = uniqueTopLeft.size();

                // bottom right calculate
                currentI = i;
                currentJ = j;
                Set<Integer> uniqueBottomRight = new HashSet<>();
                while (true) {
                    currentI++;
                    currentJ++;
                    if ((currentI >= 0 && currentI < grid.length) && (currentJ >= 0 && currentJ < grid[0].length)) {
                        uniqueBottomRight.add(grid[currentI][currentJ]);
                    } else {
                        break;
                    }
                }
                bottomRight[i][j] = uniqueBottomRight.size();
            }
        }

        int [][] ans = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans[i][j] = Math.abs(topLeft[i][j] - bottomRight[i][j]);
            }
        }

//        System.out.println("ans = ");
//        System.out.println(Arrays.deepToString(ans));
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.differenceOfDistinctValues(new int[][]{{1,2,3},{3,1,5},{3,2,1}});
        sol.differenceOfDistinctValues(new int[][]{{1}});
    }
}
