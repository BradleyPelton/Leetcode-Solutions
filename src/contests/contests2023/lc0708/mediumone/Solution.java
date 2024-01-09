package contests.contests2023.lc0708.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted after first attempt
// Accepted after rare (jump to fourth problem back to this second problem)

// I think I implemented a Dynamic Programming (DP) solution here.
// Divided the problem into subproblems (shorted path from i to z is i to j + j to z)

class Solution {
    public int maximumJumps(int[] nums, int target) {
        // We are going to build a map where the k,v are
        // index -> maximum number of jumps from this index to the end of the array.
        Map<Integer, Integer> maxNumberOfJumpsFromThisPointToEnd = new HashMap<>();

        // build the map
        int endVal = nums[nums.length - 1];
        for (int i = nums.length - 2; i > -1; i--) {
            int localMaxJumps = -1;

            int currVal = nums[i];
            if (Math.abs(currVal - endVal) <= target) {
                // if it's possible to jump straight to the end, then the max is at least 1.
                localMaxJumps = 1;
            }

            for (int j = i + 1; j < nums.length - 1; j++) {
                // for each intermediate value between the current value and end value
                int intermediateVal = nums[j];
                if (Math.abs(currVal - intermediateVal) > target) {
                    // we can't jump to this value
                    continue;
                }

                if (maxNumberOfJumpsFromThisPointToEnd.get(j) == -1) {
                    // no path from intermediate(j) to the end exists.
                    continue;
                }

                // assuming already discovered
                int maxIntermediateJumps = maxNumberOfJumpsFromThisPointToEnd.get(j);
                localMaxJumps = Math.max(localMaxJumps, maxIntermediateJumps + 1);
            }
            maxNumberOfJumpsFromThisPointToEnd.put(i, localMaxJumps);
        }

        int ans = maxNumberOfJumpsFromThisPointToEnd.get(0);
        System.out.println("ans = " + ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumJumps(new int[]{1,3,6,4,1,2}, 2);
        sol.maximumJumps(new int[]{1,3,6,4,1,2}, 3);
        sol.maximumJumps(new int[]{1,3,6,4,1,2}, 0);





    }
}
