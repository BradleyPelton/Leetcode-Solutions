package contests.contests2024.lc0120biweekly.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Accepted after 16 minutes
// Fubmedled with indices for 10 minutes
// Implmented an incorrect solution first with double sort

class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[][] adjustedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            adjustedNums[i] = new int[]{nums[i], Integer.bitCount(nums[i])};
        }

        List<Integer> sortSupposed = new ArrayList<>();

        int currIndex = 0;
        int currBitCount = adjustedNums[0][1];
        List<Integer> currVals = new ArrayList<>();
        currVals.add(nums[0]);
        while (currIndex < n) {
            currIndex++;
            if (currIndex >= n) {
                break;
            }
            int nextVal = adjustedNums[currIndex][0];
            int nextBitCount = adjustedNums[currIndex][1];
            if (nextBitCount == currBitCount) {
                currVals.add(nextVal);
            } else {
                Collections.sort(currVals);
                sortSupposed.addAll(currVals);

                currVals = new ArrayList<>();
                currVals.add(nextVal);

                currBitCount = nextBitCount;
            }
        }

        if (!currVals.isEmpty()) {
            Collections.sort(currVals);
            sortSupposed.addAll(currVals);
        }

        int previousVal = sortSupposed.get(0);
        for (int i = 1; i < n; i++) {
            int currVal = sortSupposed.get(i);
            if (currVal < previousVal) {
                System.out.println("false, problem");
                return false;
            }
            previousVal = currVal;
        }

        System.out.println("true, no problems");
        return true;
    }
}





class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canSortArray(
                new int[]{8,4,2,30,15}
        ); // true
        sol.canSortArray(
                new int[]{1,2,3,4,5}
        ); // true
        sol.canSortArray(
                new int[]{3,16,8,4,2}
        ); // false
        sol.canSortArray(
                new int[]{2,28,9}
        ); // expected false






    }
}