package contests.contests2024.lc0525biweekly.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted first try
// Accepted after 8 minutes
// Trivial, misread the question though.

class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }

        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (queries[i] - 1 >= indices.size()) {
                ans[i] = -1;
            } else {
                ans[i] = indices.get(queries[i] - 1);
            }
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.occurrencesOfElement(
                new int[]{1,3,1,7},
                new int[]{1,3,2,4},
                1
        );
        sol.occurrencesOfElement(
                new int[]{1,2,3},
                new int[]{10},
                5
        );





    }
}
