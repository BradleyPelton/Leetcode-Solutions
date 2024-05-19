package contests.contests2024.lc0511biweekly.easy;


// Accepted after 4 minutes
// Accepted first try
// Trivial. linear, Big O (m x n)

class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < m - 1 && grid[i][j] != grid[i + 1][j]) {
                    System.out.println(false);
                    return false;
                }
                if (j < n - 1 && grid[i][j] == grid[i][j + 1]) {
                    System.out.println(false);
                    return false;
                }
            }
        }
        System.out.println(true);
        return true;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.satisfiesConditions(
                new int[][]{{1,0,2},{1,0,2}}
        );
        sol.satisfiesConditions(
                new int[][]{{1,1,1},{0,0,0}}
        );
        sol.satisfiesConditions(
                new int[][]{{1},{2},{3}}
        );






    }
}