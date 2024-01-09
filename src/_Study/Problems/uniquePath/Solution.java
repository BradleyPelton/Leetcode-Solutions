package _Study.Problems.uniquePath;


/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/description/
 *
 * <p>
 *     Dynamic Programming (bottom-up) approach
 *     Time Complexity: Big O(n * m) - consider the value at all points
 *     Space Complexity: Big O(n * m) - store grid in memory
 * </p>
 */
class Solution {
    public int uniquePaths(int m, int n) {
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

    public int uniquePathsRECRURSIVE(int m, int n) {
        // TLE RECURSIVE
        if (m == 1) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return uniquePathsRECRURSIVE(m - 1, n) + uniquePathsRECRURSIVE(m, n - 1);
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol =  new Solution();
        System.out.println(sol.uniquePaths(3, 7));
        System.out.println(sol.uniquePaths(3, 2));
    }
}