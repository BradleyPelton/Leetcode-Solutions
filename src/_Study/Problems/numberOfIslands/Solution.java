package _Study.Problems.numberOfIslands;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 *
 *
 * // TODO BFS
 *
 */
class Solution {
    int m;
    int n;
    char[][] grid;
    int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) { // DFS - 33% runtime, 5% memory
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int islandCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfsSink(i, j);
                }
            }
        }
        System.out.println(islandCount);
        return islandCount;
    }

    private void dfsSink(int currI, int currJ) {
        grid[currI][currJ] = '0';

        for (int[] dir : DIRS) {
            int[] updatedCoord = {currI + dir[0], currJ + dir[1]};
            if (isValidCoordinate(updatedCoord[0], updatedCoord[1])) {
                if (grid[updatedCoord[0]][updatedCoord[1]] == '1') {
                    dfsSink(updatedCoord[0], updatedCoord[1]);
                }
            }
        }
    }

    private boolean isValidCoordinate(int i, int j) {
        return i < m && i >= 0 && j >= 0 && j < n;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numIslands(
                new char[][]{
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                }
        );
        sol.numIslands(
                new char[][]{
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                }
        );
    }
}
