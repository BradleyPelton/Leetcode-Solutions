package _Study.Problems.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/description/
 *
 * Clean solution: 71% runtime, 65% memory
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        generateSubsets(nums, 0, new LinkedList<>());
        // System.out.println(ans);
        return ans;
    }

    private void generateSubsets(int[] nums, int index, LinkedList<Integer> currList) {
        ans.add(new ArrayList<>(currList));
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length ; i++) {
            currList.add(nums[i]);
            generateSubsets(nums, i + 1, currList);
            currList.removeLast();
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.subsets(new int[]{1,2,3});
        sol.subsets(new int[]{0});
    }
}