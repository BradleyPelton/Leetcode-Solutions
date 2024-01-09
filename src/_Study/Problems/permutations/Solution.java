package _Study.Problems.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 *
 * // TODO - highly inefficient solution. bitmask?
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        permute(nums, new ArrayList<>());
        System.out.println(ans);
        return ans;
    }

    private void permute(int[] nums, List<Integer> currVals) {
        if (currVals.size() == nums.length) {
            ans.add(new ArrayList<>(currVals));
            return;
        }

        for (int val : nums) {
            if (!currVals.contains(val)) {
                currVals.add(val);
                permute(nums, currVals);
                currVals.remove(Integer.valueOf(val));
            }
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.permute(new int[]{1,2,3});
        sol.permute(new int[]{0,1});
        sol.permute(new int[]{1});
    }
}