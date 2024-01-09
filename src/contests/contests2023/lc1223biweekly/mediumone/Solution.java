package contests.contests2023.lc1223biweekly.mediumone;

import java.util.Arrays;

// Accepted after 9 minutes
// Accepted first try
// Easy prefix sum question

class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        long maxPerimeterLength = -1;
        for (int i = 2; i < n; i++) {
            if (prefixSum[i - 1] <= nums[i]) {
                continue;
            } else {
                long localLength = prefixSum[i];
                maxPerimeterLength = Math.max(maxPerimeterLength, localLength);
            }
        }

        System.out.println(maxPerimeterLength);
        return maxPerimeterLength;
    }
}





class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.largestPerimeter(new int[]{5,5,5});
        sol.largestPerimeter(new int[]{1,12,1,2,5,50,3});
        sol.largestPerimeter(new int[]{5,5,50});



    }
}
