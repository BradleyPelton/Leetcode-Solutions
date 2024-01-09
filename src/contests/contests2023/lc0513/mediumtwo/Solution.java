package contests.contests2023.lc0513.mediumtwo;

import java.util.*;

// First Attempt: TLE
//

class Solution {
    public int maxMoves(int[][] grid) {
        Queue<int[]> validCoordinatesToSearch = new ArrayDeque<>();

        // iterate over the starting elements
        int maxNumberOfMoves = 0;
        for (int i = 0; i < grid.length; i++) {

            validCoordinatesToSearch.clear();
            validCoordinatesToSearch.add(new int[]{i, 0});

            int currNumberOfMoves = 0;
            while (validCoordinatesToSearch.size() != 0) {
                int currNumberOfNodesToSearch = validCoordinatesToSearch.size();
                for (int j = 0; j < currNumberOfNodesToSearch; j++) {
                    int[] nextNode = validCoordinatesToSearch.poll();
                    incrementMoves(nextNode, grid, validCoordinatesToSearch);
                }
                if (validCoordinatesToSearch.size() != 0) {
                    currNumberOfMoves++;
                }
            }

            if (currNumberOfMoves > maxNumberOfMoves) {
                maxNumberOfMoves = currNumberOfMoves;
            }
        }

        System.out.println("ans = " + maxNumberOfMoves);
        return maxNumberOfMoves;
    }

    public void incrementMoves(int[] coord, int[][] grid, Queue<int[]> validCoordinatesToSearch) {
        int currVal = grid[coord[0]][coord[1]];

        int upRightVal;
        int[] upRightCoord = new int[]{coord[0] - 1, coord[1] + 1};
        if (
                (upRightCoord[0] < 0 || upRightCoord[0] >= grid.length)
            ||  (upRightCoord[1] < 0 || upRightCoord[1] >= grid[0].length)
        ) {
            upRightVal = Integer.MIN_VALUE;
        } else {
            upRightVal = grid[upRightCoord[0]][upRightCoord[1]];
        }

        int rightVal;
        int[] rightCord = new int[]{coord[0], coord[1] + 1};
        if (
                (rightCord[0] < 0 || rightCord[0] >= grid.length)
                ||  (rightCord[1] < 0 || rightCord[1] >= grid[0].length)
        ) {
            rightVal = Integer.MIN_VALUE;
        } else {
            rightVal = grid[rightCord[0]][rightCord[1]];
        }

        int downRightVal;
        int[] downRightCord = new int[]{coord[0] + 1, coord[1] + 1};
        if (
                (downRightCord[0] < 0 || downRightCord[0] >= grid.length)
                ||  (downRightCord[1] < 0 || downRightCord[1] >= grid[0].length)
        ) {
            downRightVal = Integer.MIN_VALUE;
        } else {
            downRightVal = grid[downRightCord[0]][downRightCord[1]];
        }

        if (upRightVal > currVal) {
            validCoordinatesToSearch.add(upRightCoord);
        }

        if (rightVal > currVal) {
            validCoordinatesToSearch.add(rightCord);
        }

        if (downRightVal > currVal) {
            validCoordinatesToSearch.add(downRightCord);
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxMoves(new int[][]{{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}});
        sol.maxMoves(new int[][]{{3,2,4},{2,1,9},{1,1,7}});
    }
}