package contests.contests2024.lc0302.mediumone;

// First attempt TLE;
// Tight restrictions
// Accepted after 24 minutes
// Total sloppyness. simple bug wasted 15 minutes.

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefixGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            int currSum = 0;
            for (int j = 0; j < n; j++) {
                currSum += grid[i][j];
                prefixGrid[i][j] = currSum;
            }
        }

        int ans = 0;

        // top left = (0,0)
        OUTER_LOOP:
        for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            int currSum = 0;
            for (int rowIndex = 0; rowIndex < m; rowIndex++) {
                currSum += prefixGrid[rowIndex][columnIndex];
                if (currSum <= k) {
                    ans++;
                } else {
                    continue OUTER_LOOP;
                }
            }

        }
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countSubmatrices(
                new int[][]{{7,6,3},{6,6,1}},
                18
        );
        sol.countSubmatrices(
                new int[][]{{7,2,9},{1,5,0},{2,6,6}},
                20
        );




    }
}
