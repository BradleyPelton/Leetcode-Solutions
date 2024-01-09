package _Study.Problems.combinationSum2TODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/description/
 * (combo sum with duplicate elements)
 *
 *
 */
class Solution {
    List<List<Integer>> ans;
    Map<Integer, Integer> occMap;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        occMap = new HashMap<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            occMap.put(candidates[i], occMap.getOrDefault(candidates[i], 0) + 1);
        }
        candidates = Arrays.stream(candidates).distinct().toArray();
        combos(candidates, target, 0, new LinkedList<>(), 0);
        System.out.println(ans);
        return ans;
    }

    private void combos(int[] candidates, int target, int currSum, LinkedList<Integer> currVals, int index) {
        if (currSum == target) {
            ans.add(new ArrayList<>(currVals));
            return;
        } else if (index == candidates.length) {
            return;
        } else if (currSum > target) {
            return;
        }

        for (int i = index; i < candidates.length ; i++) {
            int valOcc = occMap.get(candidates[i]);
            for (int occ = 1; occ <= valOcc; occ++) {
                currVals.add(candidates[i]);

                int localSum = currSum + (candidates[i] * occ);
                combos(candidates, target, localSum, currVals, i + 1);
            }
            for (int j = 0; j < valOcc; j++) {
                currVals.removeLast();
            }
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.combinationSum2(
                new int[]{10,1,2,7,6,1,5},
                8
        );
        sol.combinationSum2(
                new int[]{2,5,2,1,2},
                5
        );
    }
}
