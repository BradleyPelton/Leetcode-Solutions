package contests.contests2024.lc0608biweekly.mediumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// First attempt wrong answer. Sloppy edge case (n == 1)
// Second attempt wrong answer.
// Third attempt accepted

// Accepted after 28 minutes
// DP typical DP sequence problem.
// Fumbled with base cases. for 10 minutes

class Solution {
    int[] nums;
    int n;
    Map<Integer, List<Integer>> occMap;

    Integer[][] dp;
    public int maximumLength(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;
        occMap = new HashMap<>();
        dp = new Integer[n + 1][26];
        for (int i = 0; i < n; i++) {
            occMap.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
        }

        int ans = 1;
        for (int startIndex = 0; startIndex < n; startIndex++) {
            int localAns = recurse(startIndex, k) + 1;
            ans = Math.max(ans, localAns);
        }
        System.out.println(ans);
        return ans;
    }

    private int recurse(int index, int remainingDiffs) {
        if (index == n - 1) {
            return 0;
        }
        if (dp[index][remainingDiffs] != null) {
            return dp[index][remainingDiffs];
        }

        int ans = Integer.MIN_VALUE;
        int currVal = nums[index];
        if (remainingDiffs == 0) {
            List<Integer> occs = occMap.get(currVal);

            int currIndex = Collections.binarySearch(occs, index);
            if (currIndex == occs.size() - 1) {
                ans = 0;
            } else {
                int nextIndex = occs.get(currIndex + 1);
                ans = recurse(nextIndex, remainingDiffs) + 1;
            }
        } else {
            for (int i = index + 1; i < n; i++) {
                int localAns;
                if (nums[i] == currVal) {
                    localAns = recurse(i, remainingDiffs) + 1;
                } else {
                    localAns = recurse(i, remainingDiffs - 1) + 1;
                }
                ans = Math.max(ans, localAns);
            }
        }
        dp[index][remainingDiffs] = ans;
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
         Solution sol = new Solution();
         sol.maximumLength(
                 new int[]{1,2,1,1,3},
                 2
         );
        sol.maximumLength(
                new int[]{1,2,3,4,5,1},
                0
        );
        sol.maximumLength(
                new int[]{2},
                1
        ); // 1
        sol.maximumLength(
                new int[]{2,15},
                2
        ); // 2

    }
}
