package _Study.Problems.binarySearch;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/description/
 *
 * <p>
 *     Divide-and-conquer?
 *     Time Complexity: Big O(log n)
 *     Space Complexity: Big O(1)
 * </p>
 *
 * TODO - There are different variations of Binary Search
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int midPoint = left + (right - left) / 2;
            if (nums[midPoint] == target) {
                return midPoint;
            } else if (nums[midPoint] > target) {
                right = midPoint - 1;
            } else {
                left = midPoint + 1;
            }
        }
        return -1;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.search(new int[]{-1,0,3,5,9,12}, 9);
        sol.search(new int[]{-1,0,3,5,9,12}, 2);
    }
}