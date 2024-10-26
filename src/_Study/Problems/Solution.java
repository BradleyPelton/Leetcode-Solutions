package _Study.Problems;

class Solution {
    int[][] DIRS = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    int m;
    int n;
    int[][] board;
    boolean ansFound = false;
    public int[][] tourOfKnight(int m, int n, int r, int c) {
        this.m = m;
        this.n = n;
        board = new int[m][n];
        board[r][c] = -1;

        backtrack(r, c, 1);

        board[r][c] = 0;
//        System.out.println(Arrays.deepToString(board));
        return board;
    }

    private void backtrack(int currI, int currJ, int index) {
        if (ansFound) {
            return;
        }
        if (index == m * n) {
            ansFound = true;
            return;
        }

        for (int[] dir : DIRS) {
            int[] updatedCoord = {currI + dir[0], currJ + dir[1]};
            if (isValidCoord(updatedCoord[0], updatedCoord[1])) {
                if (board[updatedCoord[0]][updatedCoord[1]] == 0) {

                    board[updatedCoord[0]][updatedCoord[1]] = index;

                    backtrack(updatedCoord[0], updatedCoord[1], index + 1);

                    if (ansFound) {
                        return;
                    } else {
                        board[updatedCoord[0]][updatedCoord[1]] = 0;
                    }
                }
            }
        }

    }

    private boolean isValidCoord(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.tourOfKnight(1, 1, 0, 0);
        sol.tourOfKnight(3, 4, 0, 0);


    }
}






