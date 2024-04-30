package contests.contests2024.lc0427biweekly.mediumone;

// First Attempt TLE
// Second Attempt wrong answer
// Third Attempt TLE

// Fourth attempt accepted
// Painful. Double prefix 2d sum

// Annoying.



class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        long ans = 0;

        int[][] rowPrefix = new int[m][n];
        int[][] colPrefix = new int[m][n];

        for (int i = 0; i < m; i++) {
            int currOcc = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    currOcc++;
                }
                rowPrefix[i][j] = currOcc;
            }
        }

        for (int col = 0; col < n; col++) {

            int currOcc = 0;
            for (int row = 0; row < m; row++) {
                if (grid[row][col] == 1) {
                    currOcc++;
                }
                colPrefix[row][col] = currOcc;
            }
        }






        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    long localAns = 0;

                    int numberOfOnesLeft = j > 0 ? rowPrefix[i][j - 1] : 0;
                    int numberOfOnesRight = j < n - 1 ? rowPrefix[i][n - 1] - rowPrefix[i][j] : 0;

                    int numberOfOnesAbove = i > 0 ? colPrefix[i - 1][j] : 0;
                    int numberOfOnesBelow = i < m - 1 ?  colPrefix[m - 1][j] - colPrefix[i][j] : 0;

                    if (numberOfOnesRight > 0 && numberOfOnesBelow > 0) {
                        localAns += (numberOfOnesBelow * numberOfOnesRight);
                    }

                    if (numberOfOnesRight > 0 && numberOfOnesAbove > 0) {
                        localAns += (numberOfOnesAbove * numberOfOnesRight);
                    }

                    if (numberOfOnesLeft > 0 && numberOfOnesAbove > 0) {
                        localAns += (numberOfOnesAbove * numberOfOnesLeft);
                    }

                    if (numberOfOnesLeft > 0 && numberOfOnesBelow > 0) {
                        localAns += (numberOfOnesBelow * numberOfOnesLeft);
                    }

                    ans += localAns;
                }
            }
        }

        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfRightTriangles(
                new int[][]{{0,1,0},{0,1,1},{0,1,0}}
        );
        sol.numberOfRightTriangles(
                new int[][]{{1,0,0,0},{0,1,0,1},{1,0,0,0}}
        );
        sol.numberOfRightTriangles(
                new int[][]{{1,0,1},{1,0,0},{1,0,0}}
        );

        sol.numberOfRightTriangles(
                new int[][]{{0},{1}}
        );




    }
}
