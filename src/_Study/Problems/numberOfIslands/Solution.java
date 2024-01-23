package _Study.Problems.numberOfIslands;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
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

    boolean[][] seen;
    public int numIslandsBFS(char[][] grid) { // BFS - 13% runtime, 10% memory
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];

        int islandCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    islandCount++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(islandCount);
        return islandCount;
    }

    private void bfs(int startI, int startJ) {
        Queue<int[]> nodesToSearch = new ArrayDeque<>();
        nodesToSearch.add(new int[]{startI, startJ});

        while (!nodesToSearch.isEmpty()) {
            int[] currNode = nodesToSearch.remove();

            for (int[] dir : DIRS) {
                int[] updatedCoord = {currNode[0] + dir[0], currNode[1] + dir[1]};
                if (isValidCoordinate(updatedCoord[0], updatedCoord[1])) {
                    if (grid[updatedCoord[0]][updatedCoord[1]] == '1' && !seen[updatedCoord[0]][updatedCoord[1]]) {
                        seen[updatedCoord[0]][updatedCoord[1]] = true;
                        nodesToSearch.add(updatedCoord);
                    }
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
