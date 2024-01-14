package _Study.Problems.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/description/
 *
 * <p>
 *     Brute Force Approach:
 *     Time Complexity: Big O(n**3)
 *     Space Complexity: Big O(1)
 * </p>
 *
 * <p>
 *     Two Pointers Approach:
 *     Time Complexity: Big O(n**2) - n outer loops * twoPointers with at most n-1 inner loops. Sorting is n log n smaller term
 * </p>
 *
 *
 * TODO - There are some good optimizations here
 */
class Solution {
//    public List<List<Integer>> threeSumTWOPOINTER(int[] nums) { // two pointer solution
//        Arrays.sort(nums);
//        Set<List<Integer>> tupleSolutions = new HashSet<>();
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            int target = -nums[i];
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                int currSum = nums[left] + nums[right];
//                if (currSum < target) {
//                    left++;
//                } else if (currSum > target) {
//                    right--;
//                } else {
//                    tupleSolutions.add(List.of(nums[i], nums[left], nums[right]));
//                    left++; // TODO  debatable - Doesn't prevent duplicates, but prevents infinite loop.
//                }
//            }
//        }
////        System.out.println(tupleSolutions);
//        List<List<Integer>> ans = new ArrayList<>(tupleSolutions);
//        return ans;
//    }

    public List<List<Integer>> threeSum(int[] nums) { // n**2  + binary search  - Slow because of Set<List<<>>
        // TODO - Clever way of avoiding duplicates without hashing
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> tupleSolutions = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int target = -nums[i] -nums[j];

                int pos = Arrays.binarySearch(nums, j + 1, n, target);
                if (pos > 0) {
                    tupleSolutions.add(List.of(nums[i],nums[j],nums[pos]));
                }
            }
        }
        System.out.println(tupleSolutions);
        List<List<Integer>> ans = new ArrayList<>(tupleSolutions);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.threeSum(new int[]{-1,0,1,2,-1,-4});
        sol.threeSum(new int[]{0,1,1});
        sol.threeSum(new int[]{0,0,0,0,0,0,0,0});  // duplicates
        sol.threeSum(new int[]{-2,0,1,1,2});
    }
}