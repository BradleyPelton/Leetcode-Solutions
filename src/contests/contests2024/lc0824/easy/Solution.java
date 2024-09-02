package contests.contests2024.lc0824.easy;

import java.util.Arrays;

// Accepted after 3 minutes
// Trivial. COuld have used a heap for optimization.

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            int minValue = nums[0];

            for (int j = 0; j < n; j++) {
                if (nums[j] < minValue) {
                    minValue = nums[j];
                    minIndex = j;
                }
            }

            nums[minIndex] *= multiplier;
        }
//        System.out.println(Arrays.toString(nums));
        return nums;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getFinalState(
                new int[]{2,1,3,5,6},
                5,
                2
        );
        sol.getFinalState(
                new int[]{1,2},
                3,
                4
        );




    }
}
