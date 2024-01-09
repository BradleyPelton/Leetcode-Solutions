package _Study.Problems.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/description
 *
 * NOTE: A boring problem that is all index handling.
 *
 */
class Solution {
    List<Integer> ans;
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ans = new ArrayList<>();

        recursiveSpiral(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        System.out.println(ans);
        return ans;

    }

    private void recursiveSpiral(int[][] matrix, int firstRow, int lastRow, int firstColumn, int lastColumn) {
        if (firstRow > lastRow || firstColumn > lastColumn) {
            return;
        }
        // INCLUSIVE INDICES

        // TOP
        for (int column = firstColumn; column <= lastColumn; column++) {
            ans.add(matrix[firstRow][column]);
        }

        // RIGHT
        for (int row = firstRow + 1; row < lastRow; row++) {
            ans.add(matrix[row][lastColumn]);
        }

        // BOTTOM
        if (firstRow == lastRow) {
            return;
        }
        for (int column = lastColumn; column >= firstColumn ; column--) {
            ans.add(matrix[lastRow][column]);
        }

        // LEFT
        if (firstColumn == lastColumn) {
            return;
        }
        for (int row = lastRow - 1; row > firstRow ; row--) {
            ans.add(matrix[row][firstColumn]);
        }
        recursiveSpiral(matrix,
            firstRow + 1,
            lastRow - 1,
            firstColumn + 1,
            lastColumn - 1
        );
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        sol.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        sol.spiralOrder(new int[][]{{7},{9},{6}});

    }
}