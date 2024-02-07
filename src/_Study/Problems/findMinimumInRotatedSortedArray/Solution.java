package _Study.Problems.findMinimumInRotatedSortedArray;


/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 *
 * // TODO - Binary Search Iterative
 *
 */
class Solution {
    public int findMin(int[] nums) {
        int ans = findMin(nums, 0, nums.length - 1);
        System.out.println(ans);
        return ans;
    }

    private int findMin(int[] nums, int left, int right) { // Recursive Binary Search - 100% runtime, 21% memory
        if (left == right) {
            return nums[left];
        } else if (left == right - 1) {
            return Math.min(nums[left], nums[right]);
        }
        int leftVal = nums[left];
        int rightVal = nums[right];
        int mid = left + (right - left)/2;
        int midVal = nums[mid];

        if (midVal > leftVal && midVal < rightVal) {
            return findMin(nums, left, mid);
        } else if (midVal > leftVal) {
            return findMin(nums, mid, right);
        } else if (midVal < leftVal) {
            return findMin(nums, left, mid);
        } else {
            throw new IllegalStateException("unreachable");
        }
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findMin(
                new int[]{3,4,5,1,2}
        );
        sol.findMin(
                new int[]{4,5,6,7,0,1,2}
        );
        sol.findMin(
                new int[]{11,13,15,17}
        );
    }
}
