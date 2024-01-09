package contests.contests2023.lc0325.mediumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// First Attempt: TLE

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {

        Arrays.sort(nums);

        List<Long> ansList = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int desiredValue = queries[i];
            long numberOfOperations = 0L;

            for (int j = 0; j < nums.length; j++) {
                numberOfOperations += Math.abs(desiredValue - nums[j]);
            }
            ansList.add(numberOfOperations);
        }

        //System.out.println("ans  = " + ansList);
        return ansList;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minOperations(
            new int[]{3,1,6,8},
            new int[]{1,5}
        );

        sol.minOperations(
                new int[]{2,9,6,3},
                new int[]{10}
        );
    }
}