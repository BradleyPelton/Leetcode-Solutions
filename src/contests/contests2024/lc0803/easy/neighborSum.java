package contests.contests2024.lc0803.easy;

import java.util.HashMap;
import java.util.Map;

// ACcepted first try
// Accepted after 7 minutes
// Tedious easy problem. Class create first problem, interesting

class neighborSum {
    int[][] grid;
    int m;
    int n;
    Map<Integer, int[]> coordinateMapper;
    protected final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    protected final int[][] DIAGDIRS = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public neighborSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        coordinateMapper = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                coordinateMapper.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        int adjacentSum = 0;
        int[] currCoord = coordinateMapper.get(value);
        for (int[] dir : DIRS) {
            int[] updatedCoord = new int[] {currCoord[0] + dir[0], currCoord[1] + dir[1]};
            if (isValidCoordinate(updatedCoord[0], updatedCoord[1])) {
                adjacentSum += grid[updatedCoord[0]][updatedCoord[1]];
            }
        }
        System.out.println(adjacentSum);
        return adjacentSum;
    }

    public int diagonalSum(int value) {
        int diagSum = 0;
        int[] currCoord = coordinateMapper.get(value);
        for (int[] dir : DIAGDIRS) {
            int[] updatedCoord = new int[] {currCoord[0] + dir[0], currCoord[1] + dir[1]};
            if (isValidCoordinate(updatedCoord[0], updatedCoord[1])) {
                diagSum += grid[updatedCoord[0]][updatedCoord[1]];
            }
        }
        System.out.println(diagSum);
        return diagSum;
    }

    private boolean isValidCoordinate(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
