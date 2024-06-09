package contests.contests2024.lc0608biweekly.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// First attempt TLE
// Second attempt TLE
// Third attempt TLE

class Solution {
    int[] nums;
    int n;
    Map<Integer, List<Integer>> occMap;
    Map<Integer, Integer> greatestOcc;
    Integer[][] dp;
    public int maximumLength(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;
        occMap = new HashMap<>();
        greatestOcc = new HashMap<>();
        dp = new Integer[n + 1][51];
        for (int i = 0; i < n; i++) {
            occMap.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
            greatestOcc.put(nums[i], i);
        }

        int ans = 1;
        for (int val : occMap.keySet()) {
            int firstOcc = occMap.get(val).get(0);
            int localAns = recurse(firstOcc, k) + 1;
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

        // STAY ON THE SAME VAL
        int nextIndex = getNextOcc(index);
        if (nextIndex == -1) {
            ans = 0;
        } else {
            ans = recurse(nextIndex, remainingDiffs) + 1;
        }

        // CHANGE VAL;
        if (remainingDiffs != 0) {
            for (int key : occMap.keySet()) {
                if (key == currVal) {
                    continue;
                }
                int gOcc = greatestOcc.get(key);
                if (index >= gOcc) {
                    continue;
                }

                List<Integer> occs = occMap.get(key);
                int pos = Collections.binarySearch(occs, index);
                if (pos < 0) {
                    pos = -pos - 1;
                }

                int posIndex = occs.get(pos);

                int localAns = recurse(posIndex, remainingDiffs - 1) + 1;
                ans = Math.max(ans, localAns);
            }
        }
        dp[index][remainingDiffs] = ans;
        return ans;
    }

    private int getNextOcc(int index) {
        int currVal = nums[index];
        List<Integer> occs = occMap.get(currVal);

        int currIndex = Collections.binarySearch(occs, index);
        int nextOcc = -1;
        if (currIndex != occs.size() - 1) {
            nextOcc = occs.get(currIndex + 1);
        }
        return nextOcc;
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

