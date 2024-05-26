package contests.contests2024.lc0525biweekly.mediumtwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Accepted first attempt
// Accepted after 14 minutes
// Cool double hashmap problem.
// Fumbled around with variable names.

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;

        Map<Integer, HashSet<Integer>> colorMap = new HashMap<>();
        Map<Integer, Integer> currentColorMap = new HashMap<>();

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int pos = query[0];
            int colorToSet = query[1];

            if (currentColorMap.containsKey(pos)) { // if seen
                int currentColor = currentColorMap.get(pos);
                colorMap.get(currentColor).remove(pos);
                if (colorMap.get(currentColor).isEmpty()) {
                    colorMap.remove(currentColor);
                }
            }
            currentColorMap.put(pos, colorToSet);

            colorMap.computeIfAbsent(colorToSet, a -> new HashSet<>()).add(pos);

            ans[i] = colorMap.size();
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.queryResults(
                4,
                new int[][]{{1,4},{2,5},{1,3},{3,4}}
        );
        sol.queryResults(
                4,
                new int[][]{{0,1},{1,2},{2,2},{3,4},{4,5}}
        );





    }
}