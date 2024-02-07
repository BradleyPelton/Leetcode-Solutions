package _Study.Problems.twosum;

import java.util.*;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 *
 * <p>
 *     Brute Force:
 *     Time Complexity: Big O(n**2) - Quadratic
 *     Space Complexity: Big O(1) - Constant
 * </p>
 *
 * <p>
 *     HashMap
 *     Time Complexity: Big O(n) - linear - Each element is seen at most once
 *     Space Complexity: Big O(n) - linear - Worst case we store all but 1 value in a hashmap
 * </p>
 *
 */
class Solution {
    public int[] twoSum(int[] nums, int target) { // HashMap complement - 95% runtime, 18% memory
        Map<Integer, Integer> seenValues = new HashMap<>(); // nums[i] -> i (remember the index)
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seenValues.containsKey(complement)) {
                return new int[]{i, seenValues.get(complement)};
            }
            seenValues.put(nums[i], i);
        }
        throw new IllegalStateException("unreachable, solution is guaranteed as input condition");
    }
    // Two pointer solution doesn't work because sorting is required. After sorting, original indices presort are lost.
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.twoSum(new int[]{2,7,11,15}, 9);
        sol.twoSum(new int[]{3,2,4}, 6);
        sol.twoSum(new int[]{3,3}, 6);
    }
}