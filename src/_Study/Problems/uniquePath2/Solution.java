package _Study.Problems.uniquePath2;

import java.util.Arrays;

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0; // obstacle at start
        }
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0)  {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) { // if obstacle at i,j, then there are zero ways to get there.
                    obstacleGrid[i][j] = 0;
                } else {
                    int leftVal = j > 0 ? obstacleGrid[i][j - 1] : 0;
                    int upVal = i > 0 ? obstacleGrid[i - 1][j] : 0;
                    obstacleGrid[i][j] = leftVal + upVal;
                }
            }
        }

        int ans = obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
        sol.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}});
    }
}