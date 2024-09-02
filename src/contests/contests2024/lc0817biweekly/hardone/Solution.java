package contests.contests2024.lc0817biweekly.hardone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// First attempt TLE. Good backtracking attempt
// Second attempt TLE. Tried to optimize.

class Solution {
//    class Point {
//        int i;
//        int j;
//        int val;
//        public Point(int i, int j, int val) {
//            this.i = i;
//            this.j = j;
//            this.val = val;
//        }
//    }
//
//    int[][] board;
//    int m;
//    int n;
//    List<List<Point>> rowMaxValues;
//    Set<Integer> rowsExcluded;
//    Set<Integer> columnsExcluded;
//    public long maximumValueSum(int[][] board) {
//        // 100x100 is far too big for backtracking
//        // Smells like a dp problem
//        // FACT: We can't just choose the greedy (largest remaining value)
//        // Collect the three largest value in ROW and COLUMN
//        this.board = board;
//        this.m = board.length;
//        this.n = board[0].length;
//        rowMaxValues = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            PriorityQueue<Point> minPq = new PriorityQueue<>(Comparator.comparingInt((Point a) -> a.val));
//            for (int j = 0; j < n; j++) {
//                minPq.add(new Point(i, j, board[i][j]));
//                if (minPq.size() > 3) {
//                    minPq.remove();
//                }
//            }
//            List<Point> threeLargest = new ArrayList<>();
//            while (!minPq.isEmpty()) {
//                threeLargest.add(minPq.remove());
//            }
//            rowMaxValues.add(threeLargest);
//        }
//
//
//        rowsExcluded = new HashSet<>();
//        columnsExcluded = new HashSet<>();
//        long ans = recurse(0, 0L);
//        System.out.println(ans);
//        return ans;
//    }
//
//    private long recurse(int numberOfChoicesMade, long currSum) {
//        if (numberOfChoicesMade == 3) {
//            return currSum;
//        }
//
//        long ans = Long.MIN_VALUE;
//        for (int i = 0; i < m; i++) {
//            if (!rowsExcluded.contains(i)) {
//                List<Point> currRow = rowMaxValues.get(i);
//
//                rowsExcluded.add(i);
//
//                for (Point point : currRow) {
//                    if (!columnsExcluded.contains(point.j)) {
//                        columnsExcluded.add(point.j);
//                        long smallestAns = recurse(numberOfChoicesMade + 1, currSum + point.val);
//                        ans = Math.max(ans, smallestAns);
//                        columnsExcluded.remove(point.j);
//                    }
//                }
//                rowsExcluded.remove(i);
//            }
//        }
//
//        return ans;
//    }

    int[][] board;
    int m;
    int n;
    Integer[][][][] dp;
    public long maximumValueSum(int[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        dp = new Integer[101][101][101][101];

//        long ans = topDown();
        return -42;
    }

    private long topDown(int firstRow, int secondRow, int firstColumn, int secondColumn) {

        String dpKey;
//        if (dp.containsKey(dpKey)) {
//            return dp.get(dpKey);
//        }

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (i == firstRow || i == secondRow) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (j == firstColumn || j == secondColumn) {
                    continue;
                }


            }
        }

//        dp.put(dpKey, ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumValueSum(
                new int[][]{{-3,1,1,1},{-3,1,-3,1},{-3,2,1,1}}
        );
        sol.maximumValueSum(
                new int[][]{{1,2,3},{4,5,6},{7,8,9}}
        );
        sol.maximumValueSum(
                new int[][]{{1,1,1},{1,1,1},{1,1,1}}
        );




    }
}
