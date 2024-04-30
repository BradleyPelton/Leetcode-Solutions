package contests.contests2024.lc0420.mediumtwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted after 20 minutes
// Tricky DP problem.
// After a month of no DP problems, "I AM STILL WORTHY" meme.jpg

class Solution {
    int m;
    int n;
    Map<Integer, Map<Integer,Integer>> colOcc;
    int[][] dp;
    public int minimumOperations(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        colOcc = new HashMap<>();
        dp = new int[n][10];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!colOcc.containsKey(j)) {
                    colOcc.put(j, new HashMap<>());
                }
                colOcc.get(j).put(grid[i][j], colOcc.get(j).getOrDefault(grid[i][j], 0) + 1);
            }
        }

        for (int i = 0; i < 10; i++) {
            dp[n - 1][i] = m - colOcc.get(n - 1).getOrDefault(i, 0);
        }


        for (int i = n - 2; i >= 0; i--) {
            for (int colChoice = 0; colChoice < 10; colChoice++) {
                int currColSwaps = m - colOcc.get(i).getOrDefault(colChoice, 0);
                int localAns = Integer.MAX_VALUE;
                for (int nextColChoice = 0; nextColChoice < 10; nextColChoice++) {
                    if (colChoice == nextColChoice) {
                        continue;
                    }
                    localAns = Math.min(localAns, dp[i + 1][nextColChoice] + currColSwaps);
                }

                dp[i][colChoice] = localAns;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            ans = Math.min(ans, dp[0][i]);
        }
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumOperations(
                new int[][]{{1,0,2},{1,0,2}}
        );
        sol.minimumOperations(
                new int[][]{{1,1,1},{0,0,0}}
        );
        sol.minimumOperations(
                new int[][]{{1},{2},{3}}
        );



    }
}
