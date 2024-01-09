package contests.contests2023.lc1216.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Accepted after 3 minutes. Trivial

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        Map<Integer, Integer> occMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                occMap.put(val, occMap.getOrDefault(val, 0) + 1);
            }
        }

        int[] ans = new int[2];
        for (int i = 1; i <= n * n; i++) {
            if (occMap.containsKey(i)) {
                if (occMap.get(i) == 2) {
                    ans[0] = i;
                }
            } else {
                ans[1] = i;
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findMissingAndRepeatedValues(new int[][]{{1,3},{2,2}});
        sol.findMissingAndRepeatedValues(new int[][]{{9,1,7},{8,9,2},{3,4,6}});



    }
}
