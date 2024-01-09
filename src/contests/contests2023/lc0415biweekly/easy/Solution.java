package contests.contests2023.lc0415biweekly.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

// Accepted after 11 minutes
// Fooled around with indexes for a minute
// Forgot about negative edge case

class Solution {
    public int[] findColumnWidth(int[][] grid) {

        int numberOfColumns = Arrays.stream(grid).map(Array::getLength).max(Integer::compareTo).orElse(0);
        int numberOfColumns2 = Arrays.stream(grid).mapToInt(Array::getLength).max().getAsInt();

        int[] ans = new int[numberOfColumns];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int indexLength;
                if (grid[i][j] >= 0) {
                    indexLength = String.valueOf(grid[i][j]).length();
                } else {
                    indexLength = String.valueOf(Math.abs(grid[i][j])).length() + 1;
                }
                ans[j] = Math.max(indexLength, ans[j]);
            }
        }

        System.out.println(Arrays.toString(ans));
        return ans;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findColumnWidth(new int[][]{{1},{22},{333}});
        sol.findColumnWidth(new int[][]{{-15,1,3},{15,7,12},{5,6,-2}});
    }
}
