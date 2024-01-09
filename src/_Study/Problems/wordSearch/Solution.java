package _Study.Problems.wordSearch;

import java.util.Arrays;

// First attempt: TLE

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/description/
 *
 *  Great solution. 95% runtime, 63% memory
 */
class Solution {
    boolean ans = false;
    public boolean exist(char[][] board, String word) {
        OUTER_LOOP:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = '-';
                    search(board, word, i, j, 1);
                    board[i][j] = word.charAt(0);
                    if (ans) {
                        break OUTER_LOOP;
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    private void search(char[][] board, String word, int currI, int currJ, int wordIndex) {
        if (ans) {
            return;
        }
        if (wordIndex == word.length()) {
            ans = true;
            return;
        }

        char nextChar = word.charAt(wordIndex);
        // LEFT
        if (currJ > 0 && board[currI][currJ - 1] == nextChar) {
            board[currI][currJ - 1] = '-';
            search(board, word, currI, currJ - 1, wordIndex + 1);
            board[currI][currJ - 1] = nextChar;
        }

        // RIGHT
        if (currJ < board[0].length - 1 && board[currI][currJ + 1] == nextChar) {
            board[currI][currJ + 1] = '-';
            search(board, word, currI, currJ + 1, wordIndex + 1);
            board[currI][currJ + 1] = nextChar;
        }

        // UP
        if (currI > 0 && board[currI - 1][currJ] == nextChar) {
            board[currI - 1][currJ] = '-';
            search(board, word, currI - 1, currJ, wordIndex + 1);
            board[currI - 1][currJ] = nextChar;
        }

        // DOWN
        if (currI < board.length - 1 && board[currI + 1][currJ] == nextChar) {
            board[currI + 1][currJ] = '-';
            search(board, word, currI + 1, currJ, wordIndex + 1);
            board[currI + 1][currJ] = nextChar;
        }
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