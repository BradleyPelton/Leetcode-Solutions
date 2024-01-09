package contests.contests2023.lc0311.mediumone;

import java.util.Arrays;

// Accepted after 10 minutes
// Trivial for a medium
// I struggled with sorting and reversing a primitive array.
// Java makes this complciated. research.

class Solution {
    public int maxScore(int[] nums) {

        Arrays.sort(nums); // Ascending

        long prefixSum = 0L;
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixSum += nums[i];
            if (prefixSum > 0) {
                ans++;
            } else {
                break;
            }
        }

        System.out.println("ans = " + ans);
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxScore(new int[]{2,-1,0,1,-3,3,-3});
        sol.maxScore(new int[]{-2,-3,0});
    }
}
