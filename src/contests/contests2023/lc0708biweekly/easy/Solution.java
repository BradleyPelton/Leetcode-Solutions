package contests.contests2023.lc0708biweekly.easy;

import java.util.ArrayList;
import java.util.List;

// Content is null (30 minutes server down)
// First attempt wrong answer
// Accepted after 5 wrong answers.
// Sloppy variable handling. Missing a simple check 3 times

class Solution {
    public int alternatingSubarray(int[] nums) {

        int maxLengthSubArray = 0;
        OUTER_LOOP:
        for (int left = 0; left < nums.length; left++) {

            int firstInt = nums[left];
            int firstIndex = left;
            List<Integer> currSubArray = new ArrayList<>();
            currSubArray.add(nums[left]);

            for (int right = left + 1; right < nums.length; right++) {

                int currentIndex = right;
                int currentInt = nums[currentIndex];

                // positive first increment
                if (currentIndex == currentIndex + 1) {
                    if (firstInt != currentInt - 1) {
                        currSubArray.clear();
                        continue OUTER_LOOP;
                    }
                }

                if (currentIndex % 2 == firstIndex % 2) {
                    if (firstInt == currentInt) {
                        currSubArray.add(currentInt);
                    } else {
                        // broken
                        maxLengthSubArray = Math.max(maxLengthSubArray, currSubArray.size());
                        currSubArray.clear();
                        continue OUTER_LOOP;
                    }
                } else { // else odd
                    if (firstInt == currentInt - 1) {
                        currSubArray.add(currentInt);
                    } else {
                        // broken
                        maxLengthSubArray = Math.max(maxLengthSubArray, currSubArray.size());
                        currSubArray.clear();
                        continue OUTER_LOOP;
                    }
                }
                // end condition
                maxLengthSubArray = Math.max(maxLengthSubArray, currSubArray.size());
            }
            maxLengthSubArray = Math.max(maxLengthSubArray, currSubArray.size());
        }

        if (maxLengthSubArray == 1) {
            System.out.println("max = 1, returning -1");
            return -1;
        }


        System.out.println("ans = " + maxLengthSubArray);
        return maxLengthSubArray;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.alternatingSubarray(new int[]{2,3,4,3,4});  // 4
        sol.alternatingSubarray(new int[]{4,5,6});  // 2
        sol.alternatingSubarray(new int[]{31,32,31,32,33}); // expected 4
        sol.alternatingSubarray(new int[]{21,9,5}); // expected -1
        sol.alternatingSubarray(new int[]{8,4,3,2,6,4,3,5,2,8}); // expected -1
        sol.alternatingSubarray(new int[]{3,4,3,4,3,4,3,4}); // expected 8
    }
}
