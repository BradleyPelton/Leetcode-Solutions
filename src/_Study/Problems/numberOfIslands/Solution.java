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
    public int numIslands(char[][] grid) { // DFS - 23% runtime, 32% memory
        m = grid.length;
        n = grid[0].length;

        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfsIslands(grid, i, j);
                }
            }
        }
        System.out.println(islands);
        return islands;
    }

    private void dfsIslands(char[][] grid, int currI, int currJ) {
        grid[currI][currJ] = '0';


        // LEFT
        if (currJ > 0 && grid[currI][currJ - 1] == '1') {
            dfsIslands(grid, currI, currJ - 1);
        }

        // right
        if (currJ < n - 1 && grid[currI][currJ + 1] == '1') {
            dfsIslands(grid, currI, currJ + 1);
        }

        // UP
        if (currI > 0 && grid[currI - 1][currJ] == '1') {
            dfsIslands(grid, currI - 1, currJ);
        }

        // DOWN
        if (currI < m - 1 && grid[currI + 1][currJ] == '1') {
            dfsIslands(grid, currI + 1, currJ);
        }
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
