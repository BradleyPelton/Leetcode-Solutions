package _Study.Problems.containerWithMostWater;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description
 *
 * <p>
 *     Brute Force Approach:
 *     Time Complexity: Big O(n**2) - every pair of indices
 *     Space Complexity: Big O(1)
 * </p>
 *
 * <p>
 *     Two Pointer Approach:
 *     Time Complexity: Big O(n) - iterate at most through all elements once
 *     Space Complexity: Big O(1)
 * </p>
 *
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Math.min(height[left], height[right]) * (right - left );
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
        }
        return maxArea;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        sol.maxArea(new int[]{1,1});
    }
}