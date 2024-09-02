package contests.contests2024.lc0817biweekly.easy;

import java.util.Arrays;

// Accepted first attempt
// Accepted after 6 minutes
// Long easy problem

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            boolean isGoodSubarray = true;
            int previousElement = nums[i];
            int maxElement = previousElement;
            for (int j = i + 1; j < i + k; j++) {
                maxElement = Math.max(maxElement, nums[j]);
                if (nums[j] != previousElement + 1) {
                    isGoodSubarray = false;
                    break;
                }
                previousElement = nums[j];
            }

            if (!isGoodSubarray) {
                maxElement = -1;
            }

            ans[i] = maxElement;
        }

        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.resultsArray(
                new int[]{1,2,3,4,3,2,5},
                3
        );
        sol.resultsArray(
                new int[]{2,2,2,2,2},
                4
        );
        sol.resultsArray(
                new int[]{3,2,3,2,3,2},
                2
        );



    }
}
