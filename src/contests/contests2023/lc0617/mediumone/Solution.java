package contests.contests2023.lc0617.mediumone;

import java.util.Arrays;

// Accepted after 7 minutes
// Brain teaser.

class Solution {
    public int findValueOfPartition(int[] nums) {

        // min between adjacent numbers
        Arrays.sort(nums);
        int prev = nums[0];

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int currVal = nums[i];
            int diff = currVal - prev;

            if (diff < minDiff) {
                minDiff = diff;
            }
            prev = currVal;
        }

        System.out.println("ans = " + minDiff);
        return minDiff;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findValueOfPartition(new int[]{1,3,2,4});
        sol.findValueOfPartition(new int[]{100,1,10});



    }
}
