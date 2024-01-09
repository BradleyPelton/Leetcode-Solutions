package contests.contests2022.lc1126.mediumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Brute Force TLE

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        Map<Integer, List<Integer>> indexMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], new ArrayList<>());
            }
            indexMap.get(nums[i]).add(i);
        }

        List<Integer> availableVals = new ArrayList<>(indexMap.keySet());


        int[] ans = new int[nums.length];
        OUTER_LOOP:
        for (int currIndex = 0; currIndex < nums.length; currIndex++) {
            int currVal = nums[currIndex];

            int indexInVals = Collections.binarySearch(availableVals, currVal);
            if (indexInVals == 0) { // already maximally sorted
                ans[currIndex] = nums[currIndex];

                indexMap.get(currVal).remove(0);
                if (indexMap.get(currVal).isEmpty()) {
                    indexMap.remove(currVal);
                    availableVals.remove(Integer.valueOf(currVal));
                }
            } else {

                int smallestIndex = Integer.MAX_VALUE;
                int previousVal = currVal;

                for (int i = indexInVals - 1; i >= 0; i--) {
                    int possibleVal = availableVals.get(i);
                    if (Math.abs(possibleVal - previousVal) <= limit) {
                        previousVal = possibleVal;
                        smallestIndex = i;
                    } else {
                        break;
                    }
                }

                if (smallestIndex == Integer.MAX_VALUE) {
                    int nextAvail = availableVals.get(0);
                    ans[currIndex] = nextAvail;


                    indexMap.get(nextAvail).remove(0);
                    if (indexMap.get(nextAvail).isEmpty()) {
                        indexMap.remove(nextAvail);
                        availableVals.remove(Integer.valueOf(nextAvail));
                    }
                } else {
                    ans[currIndex] = previousVal;

                    indexMap.get(previousVal).remove(0);
                    if (indexMap.get(previousVal).isEmpty()) {
                        indexMap.remove(previousVal);
                        availableVals.remove(Integer.valueOf(previousVal));
                    }
                }
            }
        }

        System.out.println(Arrays.toString(ans));
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.lexicographicallySmallestArray(new int[]{1,5,3,9,8}, 2);  // [1,3,5,8,9]
//        sol.lexicographicallySmallestArray(new int[]{1,7,6,18,2,1}, 3); // [1,6,7,18,1,2]
//        sol.lexicographicallySmallestArray(new int[]{1,7,28,19,10}, 3);  // [1,7,28,19,10]
//        sol.lexicographicallySmallestArray(new int[]{1,60,34,84,62,56,39,76,49,38}, 4);  // [1,56,34,84,60,62,38,76,49,39]
        sol.lexicographicallySmallestArray(new int[]{4,52,38,59,71,27,31,83,88,10}, 14);  // [4,27,31,38,52,59,71,83,88,10]



    }
}
