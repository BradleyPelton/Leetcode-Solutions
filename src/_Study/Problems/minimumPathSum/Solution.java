package _Study.Problems.minimumPathSum;

/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 *
 *
 */
class Solution {
    public int minPathSum(int[][] grid) {
        // let grid[i][j] represent the min cost to arrive at coordinate i,j
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 & j == 0) {
                    continue;
                }
                int costFromUp = i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
                int costFromLeft = j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE;
                grid[i][j] += Math.min(costFromUp, costFromLeft);
            }
        }
        int ans = grid[grid.length - 1][grid[0].length - 1];
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
//        sol.minPathSum(new int[][]{{1,2,3},{4,5,6}});
    }
}