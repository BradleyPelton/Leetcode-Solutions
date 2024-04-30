package contests.contests2024.lc0427biweekly.easy;

// Accepted after 3 minutes
// Trivial.

class Solution {
    public boolean canMakeSquare(char[][] grid) {

        int blackCount = 0;
        int whiteCount = 0;


        blackCount = 0;
        whiteCount = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (grid[i][j] == 'B') {
                    blackCount++;
                } else {
                    whiteCount++;
                }
            }
        }
        if (whiteCount >= 3 || blackCount >= 3) {
            return true;
        }

        blackCount = 0;
        whiteCount = 0;
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (grid[i][j] == 'B') {
                    blackCount++;
                } else {
                    whiteCount++;
                }
            }
        }
        if (whiteCount >= 3 || blackCount >= 3) {
            return true;
        }

        blackCount = 0;
        whiteCount = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 3; j++) {
                if (grid[i][j] == 'B') {
                    blackCount++;
                } else {
                    whiteCount++;
                }
            }
        }
        if (whiteCount >= 3 || blackCount >= 3) {
            return true;
        }

        blackCount = 0;
        whiteCount = 0;
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (grid[i][j] == 'B') {
                    blackCount++;
                } else {
                    whiteCount++;
                }
            }
        }
        if (whiteCount >= 3 || blackCount >= 3) {
            return true;
        }

        return false;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();




    }
}
