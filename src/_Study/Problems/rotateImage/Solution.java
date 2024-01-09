package _Study.Problems.rotateImage;

import java.util.Arrays;

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/description
 *
 * <p>
 *     Approach 1: Rotate Groups of Four Cells
 * </p>
 *
 * <p>
 *     Approach 2: Transpose then reverse rows (clever)
 * </p>
 *
 *
 */
class Solution {
    public void rotate(int[][] matrix) {
        // Observe the reflection is the linear transformation ::: (i,j) -> (j, 2 - i)
        for (int i = 0; i < (matrix.length + 1)/2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int[] previousCoord = new int[]{i, j};
                int previousCoordValue = matrix[i][j];
                for (int k = 0; k < 4; k++) {  // rotate 4 coordinates (until you arrive back at the same point)

                    int[] newCoord = coordMapper(previousCoord, matrix.length);
                    int cachedValue = matrix[newCoord[0]][newCoord[1]];

                    matrix[newCoord[0]][newCoord[1]] = previousCoordValue;

                    // Update previousCoord
                    previousCoord = newCoord;
                    previousCoordValue = cachedValue;
                }
            }
        }
    }

    private int[] coordMapper(int[] previousCoord, int matrixLength) {
        return new int[]{previousCoord[1], matrixLength - 1 - previousCoord[0]};
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rotate(
                new int[][]{{1,2,3},{4,5,6},{7,8,9}}
        );
        sol.rotate(
                new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}
        );
    }
}

