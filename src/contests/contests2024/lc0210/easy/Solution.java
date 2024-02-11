package contests.contests2024.lc0210.easy;

import java.util.Arrays;

// Accepted after 3 minutes
// Trivial

class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] ans = new int[m][n];

        int[] columnMax = new int[n];
        Arrays.fill(columnMax, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = matrix[i][j];
                columnMax[j] = Math.max(columnMax[j], matrix[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == -1) {
                    ans[i][j] = columnMax[j];
                }
            }
        }

//        System.out.println(Arrays.deepToString(ans));
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.modifiedMatrix(
                new int[][]{{1,2,-1},{4,-1,6},{7,8,9}}
        );
        sol.modifiedMatrix(
                new int[][]{{3,-1},{5,2}}
        );



    }
}