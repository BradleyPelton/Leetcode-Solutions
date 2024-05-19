package contests.contests2024.lc0518.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted after 21 minutes
// Sloppy handling. Cool hashing idea.
// There is probably some clever bit solution

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {


        List<Integer> badRightIndex = new ArrayList<>();
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev % 2 == nums[i] % 2) {
                badRightIndex.add(i);
            }
            prev = nums[i];
        }
        badRightIndex.add(nums.length);

        Map<Integer, Integer> nextBadIndex = new HashMap<>();
        int bIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == badRightIndex.get(bIndex)) {
                if (bIndex == badRightIndex.size() - 1) {
                    nextBadIndex.put(i, i);
                    continue;
                } else {
                    bIndex++;
                }
            }
            int next = badRightIndex.get(bIndex);
            nextBadIndex.put(i, next);
        }


        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            int badIndex = nextBadIndex.get(left);
            if (badIndex <= right) {
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }

        System.out.println(Arrays.toString(ans));
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isArraySpecial(
                new int[]{3,4,1,2,6},
                new int[][]{{0,4}}
        );
        sol.isArraySpecial(
                new int[]{4,3,1,6},
                new int[][]{{0,2},{2,3}}
        );





    }
}