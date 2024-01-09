package contests.contests2022.lc0108.easy;

import java.util.HashSet;

// Accepted after 6 minutes
// trivial

class Solution {
    public boolean checkValid(int[][] matrix) {

        int n = matrix.length;

        // ROWS
        for (int i = 0; i < n; i++) {
            HashSet<Integer> uniqueInts = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueInts.add(matrix[i][j]);
            }

            if (uniqueInts.size() != n) {
                System.out.println("problem found with rows");
                return false;
            }
        }

        // COLUMNS
        for (int i = 0; i < matrix.length; i++) {
            // i = column
            HashSet<Integer> uniqueInts = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                uniqueInts.add(matrix[j][i]);
            }

            if (uniqueInts.size() != n) {
                System.out.println("problem found with columns");
                return false;
            }
        }

        System.out.println("no problems found");
        return true;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.checkValid(new int[][]{{1,2,3},{3,1,2},{2,3,1}});
        sol.checkValid(new int[][]{{1,1,1},{1,2,3},{1,2,3}});


    }
}
