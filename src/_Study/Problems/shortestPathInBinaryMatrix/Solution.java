package _Study.Problems.shortestPathInBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 *
 * // TODO - Cleanup BFS.
 * // (advanced. Use the A* algorithm to improve shortest path BFS)
 */
class Solution {  // BFS
    class Coordinate {
        int i;
        int j;
        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int n;
    public int shortestPathBinaryMatrix(int[][] grid) { // BFS - 76% runtime, 6% memory .
        n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            System.out.println("-1, trivial start or end");
            return -1;
        }

        Queue<Solution.Coordinate> coordinatesToCheck = new ArrayDeque<>();
        coordinatesToCheck.add(new Solution.Coordinate(0,0));
        grid[0][0] = 1;

        int pathLength = 1;
        OUTER_LOOP:
        while (true) {
            int currLevelSize = coordinatesToCheck.size();
            for (int k = 0; k < currLevelSize; k++) {
                Solution.Coordinate nextCoordinate = coordinatesToCheck.remove();

                if (nextCoordinate.i == n - 1 && nextCoordinate.j == n - 1) {
                    break OUTER_LOOP;
                }

                for (int i = nextCoordinate.i - 1; i <= nextCoordinate.i + 1; i++) {
                    for (int j = nextCoordinate.j - 1; j <= nextCoordinate.j + 1; j++) {
                        if (isValidCoordinate(i, j) && grid[i][j] == 0) {
                            grid[i][j] = 1;
                            coordinatesToCheck.add(new Solution.Coordinate(i, j));
                        }
                    }
                }
            }
            if (coordinatesToCheck.isEmpty()) {
                pathLength = -1;
                break;
            }
            pathLength++;
        }

        System.out.println(pathLength);
        return pathLength;
    }

    private boolean isValidCoordinate(int i, int j) {
        return i < n && i >= 0 && j >= 0 && j < n;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.shortestPathBinaryMatrix(
                new int[][]{{0,1},{1,0}}
        );
        sol.shortestPathBinaryMatrix(
                new int[][]{{0,0,0},{1,1,0},{1,1,0}}
        );
        sol.shortestPathBinaryMatrix(
                new int[][]{{1,0,0},{1,1,0},{1,1,0}}
        );
        sol.shortestPathBinaryMatrix(
                new int[][]{{0,0,0,0,1},{1,0,0,0,0},{0,1,0,1,0},{0,0,0,1,1},{0,0,0,1,0}}
        );
    }
}