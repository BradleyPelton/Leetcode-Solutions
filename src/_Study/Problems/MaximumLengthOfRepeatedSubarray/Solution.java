package _Study.Problems.maximumLengthOfRepeatedSubarray;

/**
 * 718. Maximum Length of Repeated Subarray
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * Cool problem. I tried to use four indices, but just tracking prefix for both works.
 */
class Solution {
    int[][] dp;
    public int findLength(int[] nums1, int[] nums2) {
        dp = new int[nums1.length + 1][nums2.length + 1];
        // Let dp[i][j] be the longest prefix for nums1[i..] nums[j..]

        int maxAns = 0;
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];    // if nums[i] == nums[j] , then we can concat the prefix of i + 1, j + 1
                    maxAns = Math.max(maxAns, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(maxAns);
        return maxAns;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findLength(
                new int[]{1,2,3,2,1},
                new int[]{3,2,1,4,7}
        );
        sol.findLength(
                new int[]{0,0,0,0,0},
                new int[]{0,0,0,0,0}
        );
    }
}