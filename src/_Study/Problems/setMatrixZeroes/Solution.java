package _Study.Problems.setMatrixZeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description
 *
 * NOTE: Trivial problem, but it's a good problem for considering improvements in space complexity.
 */
class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> zeroColumns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean containsAZero = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    containsAZero = true;
                    zeroColumns.add(j);
                }
            }
            if (containsAZero) {
                matrix[i] = new int[matrix[0].length];
            }
        }

        for (int columnIndex : zeroColumns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][columnIndex] = 0;
            }
        }
        //System.out.println(Arrays.deepToString(matrix));
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
        sol.setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}