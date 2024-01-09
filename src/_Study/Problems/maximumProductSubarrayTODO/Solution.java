package _Study.Problems.maximumProductSubarrayTODO;

import java.util.Arrays;

/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) { return 0; }

        int maxSoFar = nums[0];
        int minSoFar = nums[0]; // track both min and max since -1 * min could be > max
        int globalMax = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(
                    nums[i],
                    Math.max(
                            maxSoFar * nums[i],
                            minSoFar * nums[i]
                    )
            );
            minSoFar = Math.min(
                    nums[i],
                    Math.min(
                            maxSoFar * nums[i],
                            minSoFar * nums[i]
                    )
            );

            maxSoFar = tempMax; // don't alter the maxSoFar until after tempMax and minSoFar have been calculated.

            globalMax = Math.max(maxSoFar, globalMax);
        }
        return globalMax;
    }


    public int maxProductRECURSIVE(int[] nums) {
        // Bradley's weird recursive but not DP approach. 100% faster than others, so, meh?

        //  1,2,3, 0, 4,5,6  0, 1,2,6
        // [1,2,3] U [4,5,6] U [1,2,6]
        // Max subarray product can be split into sub-problems split on zero
        // Max subarray is a max subarary without any zeroes

        // if the product of a subarray is negative, trim either firstNegative or lastNegative

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int currProduct = 1;

        int firstNegativeIndex = Integer.MIN_VALUE;
        int lastNegativeIndex = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // Split on Zeroes
            if (nums[i] == 0) {
                return Math.max (
                        0,
                        Math.max(
                            maxProduct(Arrays.copyOfRange(nums, 0, i)),
                            maxProduct(Arrays.copyOfRange(nums, i+1, nums.length))
                ));
            }


            if (nums[i] < 0 && firstNegativeIndex == Integer.MIN_VALUE) {
                firstNegativeIndex = i;
                lastNegativeIndex = i;
            } else if (nums[i] < 0) {
                lastNegativeIndex = i;
            }
            currProduct *= nums[i];
        }

        if (currProduct < 0) {
            return Math.max(
                    maxProduct(Arrays.copyOfRange(nums, firstNegativeIndex + 1, nums.length)),
                    maxProduct(Arrays.copyOfRange(nums, 0, lastNegativeIndex))
            );
        } else {
            return currProduct;
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProduct(new int[]{2,3,-2,4});
        sol.maxProduct(new int[]{-2,0,-1});
//        System.out.println(sol.maxProduct(new int[]{-2,0})); // expected zero
    }
}