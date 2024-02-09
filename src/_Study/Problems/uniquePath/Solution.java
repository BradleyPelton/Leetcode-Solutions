package _Study.Problems.uniquePath;


import java.util.Arrays;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/description/
 *
 * <p>
 *     Dynamic Programming (bottom-up) approach
 *     Time Complexity: Big O(n * m) - consider the value at all points
 *     Space Complexity: Big O(n * m) - store grid in memory
 * </p>
 *
 *
 * Two DP Approaches:
 *         // Let dp[i][j] = the number of paths that lead to coord = {i,j}. row-major iteration. return dp[m][n]
 *         // Let dp[i][j] = the number of possible paths from {i,j} to {end}. reverse row-major iteration. return dp[0][0]
 */
class Solution {
    public int uniquePaths(int m, int n) { // DP - Bottom Up - - 100% runtime, ??% memory
        int[][] dp = new int[m][n]; // let dp[i][j] represent the number of unique paths to get to (i,j)

        for (int i = 0; i < n; i++) { // Top row
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) { // Left Column
            dp[i][0] = 1;

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    public int uniquePathsBOTTOMUPSPACEOPTIMIZED(int m, int n) { // DP - Bottom Up - Space Optimized - 100% runtime, 80% memory
        int[] previousRow = new int[n];
        Arrays.fill(previousRow, 1);
        for (int i = m - 2; i >= 0; i--) {
            int[] currRow = new int[n];
            currRow[n - 1] = 1; // the last column there is always only one path

            for (int j = n - 2; j >= 0; j--) {
                currRow[j] = currRow[j + 1] // right
                        + previousRow[j]; // down
            }
            previousRow = currRow;
        }

        return previousRow[0];
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol =  new Solution();
        sol.uniquePaths(3, 7);
        sol.uniquePaths(3, 2);
    }
}