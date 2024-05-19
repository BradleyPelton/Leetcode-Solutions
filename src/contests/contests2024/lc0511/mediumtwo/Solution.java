package contests.contests2024.lc0511.mediumtwo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
//    public int maxScore(List<List<Integer>> grid) {
//        int m = grid.size();
//        int n = grid.get(0).size();
//
//        int[][] dp = new int[m][n];
//        int ans = Integer.MIN_VALUE;
//        for (int i = m - 1; i >= 0; i--) {
//            for (int j = n - 1; j >= 0; j--) {
//                int localAns = Integer.MIN_VALUE;
//
//                for (int k = i + 1; k < m; k++) {
//                    int scoreVal = (grid.get(k).get(j) - grid.get(i).get(j)) + dp[k][j];
//                    localAns = Math.max(localAns, scoreVal);
//                }
//
//                for (int k = j + 1; k < n; k++) {
//                    int scoreVal = (grid.get(i).get(k) - grid.get(i).get(j)) + dp[i][k];
//                    localAns = Math.max(localAns, scoreVal);
//                }
//
//                dp[i][j] = Math.max(localAns, 0); // or else do nothing.
//                ans = Math.max(ans, localAns);
//            }
//        }
//
//        System.out.println(ans);
//        return ans;
//    }

    int m;
    int n;

    Integer[][] dpPositive;
    List<List<Integer>> grid;
    public int maxScore(List<List<Integer>> grid) {
        this.grid = grid;
        m = grid.size();
        n = grid.get(0).size();

        dpPositive = new Integer[m][n];

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int localAns = topDown(i, j);
                ans = Math.max(ans, localAns);
            }
        }
        System.out.println(ans);
        return ans;
    }

    private int topDown(int currI, int currJ) {
        if (dpPositive[currI][currJ] != null) {
            return dpPositive[currI][currJ];
        }

        int ans = Integer.MIN_VALUE;
        int currVal = grid.get(currI).get(currJ);
        for (int i = currI + 1; i < m; i++) {
            int localAns = grid.get(i).get(currJ) - currVal + topDown(i, currJ);
            ans = Math.max(localAns, ans);
        }
        for (int j = currJ + 1; j < n; j++) {
            int localAns = grid.get(currI).get(j) - currVal  + topDown(currI, j);
            ans = Math.max(localAns, ans);
        }


        dpPositive[currI][currJ] = ans;
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxScore(
                Arrays.stream(new int[][]{{9,5,7,3},{8,9,6,1},{6,7,14,3},{2,5,3,1}}).map(i -> Arrays.stream(i).boxed().collect(Collectors.toList())).collect(Collectors.toList())
        ); // 9
        sol.maxScore(
                Arrays.stream(new int[][]{{4,3,2},{3,2,1}}).map(i -> Arrays.stream(i).boxed().collect(Collectors.toList())).collect(Collectors.toList())
        ); // -1
        sol.maxScore(
                Arrays.stream(new int[][]{{6,5,1},{5,7,9},{6,7,4},{6,10,5}}).map(i -> Arrays.stream(i).boxed().collect(Collectors.toList())).collect(Collectors.toList())
        ); // 8




    }
}