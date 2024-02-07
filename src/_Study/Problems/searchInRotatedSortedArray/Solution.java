package _Study.Problems.searchInRotatedSortedArray;

import java.util.Arrays;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 *
 *
 *
 * // TODO - Modified Binary Search in one step
 *
 */
class Solution {
    public int search(int[] nums, int target) { // Binary Search - 5% runtime, 61% memory
        int n = nums.length;
        int minIndex = findMin(nums);

        if (minIndex == 0) {
            return binarySearchStar(nums, 0, n - 1, target);
        } else if (nums[0] <= target && target <= nums[minIndex - 1]) {
            return binarySearchStar(nums, 0, minIndex - 1, target);
        } else {
            return binarySearchStar(nums, minIndex, n - 1, target);
        }
    }


    private int binarySearchStar(int[] nums, int left, int right, int target) {
        if (left > right) {
            System.out.println(-1);
            return -1;
        } else if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
        int pos = Arrays.binarySearch(nums, left, right + 1, target);
        if (pos < 0) {
            System.out.println(-1);
            return -1;
        } else {
            System.out.println(pos);
            return pos;
        }
    }

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) { // Recursive Binary Search - 100% runtime, 21% memory
        if (left == right) {
            return left;
        } else if (left == right - 1) {
            if (nums[left] < nums[right]) {
                return left;
            } else {
                return right;
            }
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
//        sol.search(new int[]{4,5,6,7,0,1,2}, 0); // 4
//        sol.search(new int[]{4,5,6,7,0,1,2}, 3); // -1
//        sol.search(new int[]{1}, 0); // -1
//        sol.search(new int[]{1,3}, 0);
//        sol.search(new int[]{1,3,5}, 0); // expected - 1
//        sol.search(new int[]{3, 5, 1}, 1); // expected 2
        sol.search(new int[]{1,3}, 3); // expected 1
    }
}
