package _Study.Problems.combinationSumTODO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 *
 * Excellent backtracking problem.
 * Unique combinations (unique across permutation) forces a clever use of indices.
 *
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        combos(candidates, target, new LinkedList<>(), 0, 0);
        System.out.println(ans);
        return ans;
    }

    private void combos(int[] candidates, int target, LinkedList<Integer> currVals, int currSum, int index) {
        if (currSum > target) {
            return;
        } else if (currSum == target) {
            ans.add(new ArrayList<>(currVals));
            return;
        } else if (index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int val = candidates[i];
            int numberOfValsAdded = 0;
            for (int j = 1; j < 40; j++) { // TODO - No need to overcomplicate this. remove multiplicity
                if (currSum + (val * j) <= target) {
                    numberOfValsAdded++;
                    currVals.add(val);
                    combos(candidates, target, currVals, currSum + (val * j), i + 1);
                } else {
                    break;
                }
            }
            for (int j = 0; j < numberOfValsAdded; j++) {
                currVals.removeLast();
            }
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.combinationSum(
                new int[]{2,3,6,7},
                7
        );
        sol.combinationSum(
                new int[]{2,3,5},
                8
        );
        sol.combinationSum(
                new int[]{2},
                1
        );
    }
}