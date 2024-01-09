package _Study.Problems.nQueens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/description/
 *
 * Cool backtracking problem.
 *
 * 15% runtime, 85% memory
 */
class Solution {
    List<List<String>> ans;
    LinkedList<Integer> columnsUsed;
    LinkedList<Integer> ijDiffs;
    LinkedList<Integer> ijSums;
    String row;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();

        columnsUsed = new LinkedList<>();
        ijDiffs = new LinkedList<>();
        ijSums = new LinkedList<>();
        row = ".".repeat(n);
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(row);
        }
        solve(board, 0, n);
        System.out.println(ans);
        return ans;
    }

    private void solve(List<String> board, int queensPlaced, int remainingQueensToPlace) {
        if (remainingQueensToPlace == 0) {
            ans.add(new ArrayList<>(board));
        }

        int n = queensPlaced + remainingQueensToPlace;
        int i = queensPlaced; // current Row
        for (int j = 0; j < n; j++) {
            int localIJDiff = i - j;
            int localIJSum = j + i;
            if (ijDiffs.contains(localIJDiff) || ijSums.contains(localIJSum) || columnsUsed.contains(j)) {
                continue;
            } else {
                ijDiffs.add(localIJDiff);
                ijSums.add(localIJSum);
                columnsUsed.add(j);
                StringBuilder changedRow = new StringBuilder(row);
                changedRow.setCharAt(j, 'Q');
                board.set(i, changedRow.toString());

                solve(board, queensPlaced + 1, remainingQueensToPlace - 1);

                board.set(i, row);
                ijDiffs.removeLast();
                ijSums.removeLast();
                columnsUsed.removeLast();
            }
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solveNQueens(4);
        sol.solveNQueens(1);
    }
}
