package contests.contests2024.lc0817biweekly.mediumone;

import java.util.Arrays;

// Three wrong answer. Sloppy edge case handling
// Fourth attempt wrong answer. unbelievable.
// Fifth attempt wrong answer. unbelievable.

// Sixth attempt accepted at 10:01 am
// Very sloppy. Off by one errors, out of index errors, sloppy sloppy sloppy


class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                ans[i] = nums[i];
            }
//            System.out.println(Arrays.toString(ans));
            return ans;
        } else {
            Arrays.fill(ans, -1);
        }


        OUTER_LOOP:
        for (int startingIndex = 0; startingIndex < n - k + 1; startingIndex++) {
            int previousElement = nums[startingIndex];
            for (int j = startingIndex + 1; j < startingIndex + k; j++) {
                if (nums[j] != previousElement + 1) {
//                    startingIndex = j - 1;
                    continue OUTER_LOOP;
                }
                previousElement = nums[j];
            }

            ans[startingIndex] = nums[startingIndex + k - 1];

            // IF WE ARE IN A GOOD SUBARRAY
            while (startingIndex < n - k) {
                int lastElement = nums[startingIndex + k - 1];
                int nextElement = nums[startingIndex + k];
                if (nextElement == lastElement + 1) {
                    ans[startingIndex + 1] = nextElement;
                    startingIndex++;
                } else {
                    break;
                }
            }
        }

//        System.out.println(Arrays.toString(ans));
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
        sol.resultsArray(
                new int[]{1},
                1
        ); // 1
        sol.resultsArray(
                new int[]{1,1},
                1
        ); // [1,1]
        sol.resultsArray(
                new int[]{2,3},
                2
        ); // [3]





    }
}
