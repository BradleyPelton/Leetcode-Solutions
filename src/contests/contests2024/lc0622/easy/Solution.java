package contests.contests2024.lc0622.easy;

import java.util.Arrays;

// Accepted after 5 minutes
// Godzilla had a stroke while reading this problem description and fucking died
// Trivial, but horrible wording

class Solution {
    public double minimumAverage(int[] nums) {

        int n = nums.length; // n  even

        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;


        double minAverage = Double.MAX_VALUE;
        for (int i = 0; i < n/2; i++) {
            double localAverage = (nums[left] + nums[right] )/ 2.0;
            minAverage = Math.min(minAverage, localAverage);
            left++;
            right--;
        }
        System.out.println(minAverage);
        return minAverage;


    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumAverage(
                new int[]{7,8,3,4,15,13,4,1}
        );
        sol.minimumAverage(
                new int[]{1,9,8,3,10,5}
        );
        sol.minimumAverage(
                new int[]{1,2,3,7,8,9}
        );






    }
}
