package contests.contests2024.lc0803biweekly.mediumone;

// First attempt wrong answer, off by one error
// SEcond attempt accepted
// Accepted after 9 minutes
// Cool problem, was concerned it was going to require a lot of DP

class Solution {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        int numberOfOperationsRow = 0;
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            int localOps = numberOfOperationsToMakePalindromic(row);
            numberOfOperationsRow += localOps;
        }

        int numberOfOperationsColumn = 0;
        for (int j = 0; j < n; j++) {
            int[] column = new int[m];
            for (int i = 0; i < m; i++) {
                column[i] = grid[i][j];
            }
            int localOps = numberOfOperationsToMakePalindromic(column);
            numberOfOperationsColumn += localOps;
        }

        int ans = Math.min(numberOfOperationsRow, numberOfOperationsColumn);
        System.out.println(ans);
        return ans;
    }

    private int numberOfOperationsToMakePalindromic(int[] nums) {
        int numberOfOps = 0;
        int n = nums.length;
        for (int i = 0; i < n/2; i++) {
            if (nums[i] != nums[n - i - 1]) {
                numberOfOps++;
            }
        }
        return numberOfOps;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minFlips(
                new int[][]{{1,0,0},{0,0,0},{0,0,1}}
        );
        sol.minFlips(
                new int[][]{{0,1},{0,1},{0,0}}
        );
        sol.minFlips(
                new int[][]{{1},{0}}
        );

        sol.minFlips(
                new int[][]{{0,1},{1,1}}
        ); // 1




    }
}
