package contests.contests2024.lc0706.mediumtwo;

// Accepted after 14 minutes
// Trivial prefixSum

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] xPrefixSum = new int[m][n];
        int[][] yPrefixSum = new int[m][n];

        for (int i = 0; i < m; i++) {

            int numberOfXs = 0;
            int numberOfYs = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X') {
                    numberOfXs++;
                } else if (grid[i][j] == 'Y') {
                    numberOfYs++;
                }

                xPrefixSum[i][j] = numberOfXs;
                yPrefixSum[i][j] = numberOfYs;
            }
        }

        int ans = 0;
        for (int numberOfColumns = 0; numberOfColumns < n; numberOfColumns++) {
            int xCount = 0;
            int yCount = 0;
            for (int numberOfRows = 0; numberOfRows < m; numberOfRows++) {
                xCount += xPrefixSum[numberOfRows][numberOfColumns];
                yCount += yPrefixSum[numberOfRows][numberOfColumns];

                if (xCount > 0) {
                    if (xCount == yCount) {
                        ans++;
                    }
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
        sol.numberOfSubmatrices(
                new char[][]{{'X','Y','.'},{'Y','.','.'}}
        );
        sol.numberOfSubmatrices(
                new char[][]{{'X','X'},{'X','Y'}}
        );
        sol.numberOfSubmatrices(
                new char[][]{{'.','.'},{'.','.'}}
        );



    }
}
