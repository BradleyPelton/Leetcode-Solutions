package contests.contests2024.lc0831.hardone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// First attempt TLE: 10x10 backtracking. Thousands of peoples also got TLE

class Solution {
    List<List<Integer>> grid;
    int m;
    int n;
    int maxScore;

//    Integer[][] dp;
    public int maxScore(List<List<Integer>> grid) {
        this.grid = grid;
        this.m = grid.size();
        this.n = grid.get(0).size();
//        dp = new Integer[m][n];


        /**
         * Screams DP. Making decisions that impact future decisions.
         *
         * Tracking state of 10x10 elements is not practical? Bitmask can't hold that many bits.
         *
         * The size of the grid element is notably small: 1 <= grid[i][j] <= 100
         *
         * [ 5, 3, 2]
         * [ 5, 1, 0]
         * [ 5, 2, -4]
         * [ 5, 4, 3]
         *
         */

        for (int i = 0; i < n; i++) {
            Collections.sort(grid.get(i));
        }

        boolean[] solvedRows = new boolean[m];
        int numberOfSolvedRows = 0;

        int[] rowIndex = new int[m];


        // Greedy - Reconcile the largest element
        int ans = 0;
        while (numberOfSolvedRows != m) {
            int[] currRowValues = new int[101];

            for (int i = 0; i < m; i++) {
                if (!solvedRows[i]) {
                    currRowValues[grid.get(i).get(rowIndex[i])]++;
                }
            }

            for (int i = 0; i < m; i++) {
                if (!solvedRows[i]) {
                    if (currRowValues[grid.get(i).get(rowIndex[i])] == 1) {
                        ans += grid.get(i).get(rowIndex[i]);
                        numberOfSolvedRows++;
                        solvedRows[i] = true;
                    }
                }
            }

            int contestedValue = -1;
            for (int i = 0; i < 101; i++) {
                if (currRowValues[i] > 1) {
                    contestedValue = i;
                    break;
                }
            }

            if (contestedValue == -1)  throw new IllegalStateException("contestedValue = -1");

            List<Integer> rowsFightingForContestedValue = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (!solvedRows[i]) {
                    if (grid.get(i).get(rowIndex[i]) == contestedValue) {
                        rowsFightingForContestedValue.add(i);
                    }
                }
            }
            if (rowsFightingForContestedValue.size() < 2) throw new IllegalStateException("rowsFighting < 1");

            int smallestNextElement = Integer.MAX_VALUE;
            int rowWithSmallestNextElement = -1;
            for (int row : rowsFightingForContestedValue) {
                // if row[rowIndex + 1] is much smaller, prioritize this row for selection
                int nextElement = grid.get(row).get(rowIndex[row] + 1);
            }
        }



        maxScore = Integer.MIN_VALUE;
//        backtrack(new HashSet<>(), 0, 0);
        System.out.println(maxScore);
        return maxScore;
    }

//    private void topDown(int row) {
//        if (row == m) {
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//
//
//        }
//    }


//    private void backtrack(Set<Integer> seenValues, int row, int currSum) {
//        if (row == m) {
//            return;
//        }
//
//        backtrack(seenValues, row + 1, currSum);
//
//        for (int i = 0; i < n; i++) {
//            int currVal = grid.get(row).get(i);
//            maxScore = Math.max(maxScore, currVal);
//            if (!seenValues.contains(currVal)) {
//                int updatedSum = currSum + currVal;
//                maxScore = Math.max(maxScore, updatedSum);
//
//                seenValues.add(currVal);
//                backtrack(seenValues, row + 1, updatedSum);
//                seenValues.remove(currVal);
//            }
//        }
//    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxScore(
                Arrays.stream(new int[][]{{1,2,3},{4,3,2},{1,1,1}})
                        .map(i -> Arrays.stream(i)
                                .boxed()
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList())
        );
        sol.maxScore(
                Arrays.stream(new int[][]{{8,7,6},{8,3,2}})
                        .map(i -> Arrays.stream(i)
                                .boxed()
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList())
        );
//        sol.maxScore(
//                Arrays.stream(new int[][]{{1,2,3},{-1, -2, -3}})
//                        .map(i -> Arrays.stream(i)
//                                .boxed()
//                                .collect(Collectors.toList()))
//                        .collect(Collectors.toList())
//        );





    }
}
