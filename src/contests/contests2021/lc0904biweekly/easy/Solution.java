package contests.contests2021.lc0904biweekly.easy;

import java.util.Arrays;

// Accepted after 10 minutes
// Trivial after you undestand the cryptic problem phrasing

class Solution {
    public int findMiddleIndex(int[] nums) {

        long sum = Arrays.stream(nums).sum();

        double halfSum = ((double) sum)/2;
        System.out.println("halfsum equals " + halfSum);

        long currentLeftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            double exclusionSum = ((double) sum - nums[i])/2;
            if (currentLeftSum == exclusionSum) {
                System.out.println("halfsum found at i =" + i);
                return i;
            }
            currentLeftSum += nums[i];
        }

        System.out.println("no answer found, returning -1");
        return -1;
    }
}

class tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.findMiddleIndex(new int[]{2,3,-1,8,4});
        sol.findMiddleIndex(new int[]{1,-1,4});
        sol.findMiddleIndex(new int[]{2,5});
        sol.findMiddleIndex(new int[]{1});

    }
}