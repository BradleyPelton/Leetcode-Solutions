package contests.contests2023.lc0415.easy;

import java.util.Arrays;

// Accepted first try, accepted after 4 minutes
// Easy problem. Applying streams just for practice

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {

        int maxNumberOfOnes = 0;
        int rowIndexOfMaxRow = 0;

        for(int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int countOfOnes = (int) Arrays.stream(row).filter(x -> x == 1).count();
            if (countOfOnes > maxNumberOfOnes) {
                maxNumberOfOnes = countOfOnes;
                rowIndexOfMaxRow = i;
            }
        }

        int[] ans = {rowIndexOfMaxRow, maxNumberOfOnes};
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rowAndMaximumOnes(new int[][]{{0,1},{1,0}});
        sol.rowAndMaximumOnes(new int[][]{{0,0,0},{0,1,1}});
        sol.rowAndMaximumOnes(new int[][]{{0,0},{1,1},{0,0}});
    }
}
