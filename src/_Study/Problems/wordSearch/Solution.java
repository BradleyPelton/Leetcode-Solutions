package _Study.Problems.wordSearch;

import java.util.Arrays;

// First attempt: TLE

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/description/
 *
 */
class Solution {
    char[][] board;
    String word;
    int m;
    int n;
    int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;

        boolean ans = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = '?';
                    boolean localAns = wordExists(1, i, j);
                    if (localAns) {
                        ans = localAns;
                        break;
                    }
                    board[i][j] = word.charAt(0);
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    private boolean wordExists(int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        for (int[] dir : DIRS) {
            int[] updatedCoord = {i + dir[0], j + dir[1]};
            if (isValidCoordinate(updatedCoord[0], updatedCoord[1])) {
                if (board[updatedCoord[0]][updatedCoord[1]] == word.charAt(index)) {
                    board[updatedCoord[0]][updatedCoord[1]] = '?';
                    boolean localAns = wordExists(index + 1, updatedCoord[0], updatedCoord[1]);
                    if (localAns) {
                        return localAns;
                    }
                    board[updatedCoord[0]][updatedCoord[1]] = word.charAt(index);
                }
            }
        }
        return false;
    }

    private boolean isValidCoordinate(int i, int j) {
        return i < m && i >= 0 && j >= 0 && j < n;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.exist(
                new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
                "ABCCED"
        );
        sol.exist(
                new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
                "SEE"
        );
        sol.exist(
                new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
                "ABCB"
        );
    }
}