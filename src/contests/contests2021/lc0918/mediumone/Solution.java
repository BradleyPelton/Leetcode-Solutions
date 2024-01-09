package contests.contests2021.lc0918.mediumone;

import java.util.HashMap;
import java.util.Map;

// Accepted after 18 minutes
// Cool problem. Gotta optimize

// Remember what the greatest sum and greatest min was before and after

// Worked without debugging or testing. Getting much better at handling edge cases.

class Solution {
    public int sumOfBeauties(int[] nums) {

        boolean[] meetsConditionTwo = new boolean[nums.length];

        // nums[0] can never be "beauty-2" because 0 <= j < i thus i != 0


        Map<Integer,Integer> maxbeforeFarMap = new HashMap<>();
        Map<Integer,Integer> minAfterFarMap = new HashMap<>();


        int maxSoFar = nums[0];
        int minSoFar = nums[nums.length - 1];

//        maxbeforeFarMap.put(0, maxSoFar);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > maxSoFar) {
                maxSoFar = nums[i-1];
            }
            maxbeforeFarMap.put(i, maxSoFar);
        }

//        minAfterFarMap.put(nums.length - 1, minSoFar);
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i+1] < minSoFar) {
                minSoFar = nums[i+1];
            }
            minAfterFarMap.put(i, minSoFar);
        }



        int finalScore = 0;
        // CALCULATE SCORES
        for (int i = 1; i < nums.length - 1; i++) {
            int maxBefore = maxbeforeFarMap.get(i);
            int minAfter = minAfterFarMap.get(i);

            boolean allLessThan =  maxBefore < nums[i];
            boolean allGreaterThan =  minAfter > nums[i];
            if (allLessThan && allGreaterThan) {
                finalScore += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                finalScore++;
            }
        }

        System.out.println("final score is " + finalScore);
        return finalScore;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.sumOfBeauties(new int[]{1,2,3});
        sol.sumOfBeauties(new int[]{2,4,6,4});
        sol.sumOfBeauties(new int[]{3,2,1});
    }
}
