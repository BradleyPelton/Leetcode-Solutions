package contests.contests2023.lc1216.hard;

import java.util.Arrays;

class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length;
        return -42;

        // SKETCHY BIG O(n **2) for 10**5. Abandon.

        // Theory : The optimal val is always contained in nums

//        int maxFreq = 0;
//        for (int i = 0; i < n; i++) {
//            int localFreq = 1;
//
//            // iterate outwards
//            long changesLeft = k;
//            int diff = 1;
//            int
//            while (changesLeft > 0) {
//                long leftDiff;
//                long rightDiff;
//                if (i - diff >= 0 && i + diff < n) {
//                    leftDiff = nums[i] - nums[i - diff];
//                    rightDiff = nums[i + diff] - nums[i];
//                    if (leftDiff < rightDiff) {
//                        if (leftDiff < changesLeft) {
//                            changesLeft -= leftDiff;
//                            localFreq++;
//                        } else {
//                            break;
//                        }
//
//                    } else {
//
//                    }
//
//                } else if (i + diff < n) {
//                } else {
//
//                }
//
//
//            }
//            if (i - )
//            long leftDiff = nums[i]
//
//        }

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxFrequencyScore(
                new int[]{1,2,6,4},
                3
        );
        sol.maxFrequencyScore(
                new int[]{1,4,4,2,4},
                0
        );
    }
}