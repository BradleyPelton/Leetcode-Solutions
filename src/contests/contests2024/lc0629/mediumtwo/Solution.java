package contests.contests2024.lc0629.mediumtwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// first attempt wrong answer edge case
// second attempt wrong answer edge case
// three wrong answers, valid wrong answer

// Fourth answer accepted
// I pivoted 4 times during this question. I was convinced it was a DP problem (because subsequence)

// The answer turned out to be simple brute force with a HashMap
// I fumbled with merging two lists for 20 minutes. Really sloppy

class Solution {
    int[] nums;
    int n;
    int k;
    Map<Integer, List<Integer>> indicesMap;
    Integer[] dp;
    public int maximumLength(int[] nums, int k) {
        if (nums.length == 2) {
            System.out.println(2);
            return 2;
        }
        this.nums = nums;
        this.n = nums.length;
        this.k = k;
        indicesMap = new HashMap<>();
        dp = new Integer[n];

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] % k;
            indicesMap.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
        }

        int ans = 2;
        // STICK WITH SAME MODULO CLASS
        for (int leftKey : indicesMap.keySet()) {
            ans = Math.max(ans, indicesMap.get(leftKey).size());
            List<Integer> leftIndices = indicesMap.get(leftKey);

            for (int rightKey : indicesMap.keySet()) {
                if (leftKey == rightKey) {
                    continue;
                }
                List<Integer> rightIndices = indicesMap.get(rightKey);
                int leftFirst = twoPointerListSum(leftIndices, rightIndices);
                int rightFirst = twoPointerListSum(rightIndices, leftIndices);
                int localAns = Math.max(leftFirst, rightFirst);
                ans = Math.max(ans, localAns);
            }
        }

        System.out.println(ans);
        return ans;
    }

    private int twoPointerListSum(List<Integer> listOne, List<Integer> listTwo) {
        int sequenceLength = 1;
        int listOneIndex = 1;
        int listTwoIndex = 0;
        int lastVal = listOne.get(0);
        boolean isListOneTurn = false;
        while (true) {
            if (!isListOneTurn) {
                if (listTwoIndex >= listTwo.size()) {
                    break;
                }
                int currListTwoVal = listTwo.get(listTwoIndex);
                if (currListTwoVal > lastVal) {
                    sequenceLength++;
                    lastVal = currListTwoVal;

                    isListOneTurn = true;
                }
                listTwoIndex++;
            } else { // !isListOneTurn
                if (listOneIndex >= listOne.size()) {
                    break;
                }
                int currListOneVal = listOne.get(listOneIndex);
                if (currListOneVal > lastVal) {
                    sequenceLength++;
                    lastVal = currListOneVal;

                    isListOneTurn = false;
                }
                listOneIndex++;
            }
        }

        return sequenceLength;
    }



//    private int recursive(int index) {
//        if (index >= n) {
//            return 0;
//        }
//
////        if (dp[index] != null) {
////            return dp[index];
////        }
//
//        int currVal = nums[index];
//        int complement = k - 1 - currVal;
//
//        int ans = 0;
//        if (indicesMap.containsKey(complement)) {
//            List<Integer> indices = indicesMap.get(complement);
//            int nextIndex = -1;
//            for (int i = 0; i < indices.size(); i++) {
//                if (indices.get(i) > index) {
//                    nextIndex = indices.get(i);
//                    break;
//                }
//            }
//
//            if (nextIndex != -1) {
//                ans = recursive(nextIndex) + 1;
//            }
//        }
//
////        dp[index] = ans;
//        return ans;
//    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumLength(
                new int[]{1,2,3,4,5},
                2
        );
        sol.maximumLength(
                new int[]{1,4,2,3,1,4},
                3
        );
        sol.maximumLength(
                new int[]{2,10},
                7
        );
        sol.maximumLength(
                new int[]{1,7,9},
                10
        ); // 2
        sol.maximumLength(
                new int[]{8,2,8},
                5
        ); // 3



    }
}
