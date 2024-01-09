package contests.contests2023.lc0603.mediumtwo;

import java.util.*;

// memory limit exceeded
// wrong answer
// wrong answer

// Brute force was memory limit exceeded
// Figured out the optimal solution pretty quickly, but fumbled two different variable names and got wrong answers.

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {

        long ans = 0;


        Set<Integer> columnsSet  = new HashSet<>();
        Set<Integer> rowsSet = new HashSet<>();
        for (int i = queries.length - 1; i >= 0 ; i--) {
            int[] query = queries[i];
            if (query[0] == 0) {
                int rowIndex = query[1];
                int val = query[2];

                if (rowsSet.contains(rowIndex)) {
                    // do nothing
                } else {
                    rowsSet.add(rowIndex);

                    ans += (long) val * (n - columnsSet.size());
                }

            } else { // else query[0] == 1
                int columnIndex = query[1];
                int val = query[2];

                if (columnsSet.contains(columnIndex)) {
                    // do nothing
                } else {
                    columnsSet.add(columnIndex);

                    ans += (long) val * (n - rowsSet.size());
                }

            }

        }

//        int[][] grid = new int[n][n];
//
//        for (int[] query : queries) {
//            if (query[0] == 0) {
//                int rowIndex = query[1];
//                int val = query[2];
//
//                for (int i = 0; i < n; i++) {
//                    grid[rowIndex][i] = val;
//                }
//            } else { // else query[0] == 1
//                int columnIndex = query[1];
//                int val = query[2];
//
//                for (int i = 0; i < n; i++) {
//                    grid[i][columnIndex] = val;
//                }
//            }
//        }
//
//        long ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                ans += grid[i][j];
//            }
//        }


        System.out.println("ans = "  + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.matrixSumQueries(
                3,
                new int[][]{{0,0,1},{1,2,2},{0,2,3},{1,0,4}}
        );
        sol.matrixSumQueries(
                3,
                new int[][]{{0,0,4},{0,1,2},{1,0,1},{0,2,3},{1,2,1}}
        );

        sol.matrixSumQueries(
                2,
                new int[][]{{1,1,1},{1,0,7}}
        ); // expected 16

        sol.matrixSumQueries(
                3,
                new int[][]{{0,0,6},{0,2,11},{0,1,9}}
        ); // expected 78

    }
}