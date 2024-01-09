package contests.contests2023.lc0701.easy;

import java.util.Arrays;


// Extremely frustrating easy problem
// Lots of edge cases
// Accepted after 18 minutes
// Accepted after 5 incorrect answers
// Sloppy.

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {

        if (nums.length == 1) {
            if (nums[0] % 2 != 0 || nums[0] > threshold) {
                System.out.println(0);
                return 0;
            } else {
                System.out.println(1);
                return 1;
            }


        }

        int maxSubArrayLength = 0;
        for (int left = 0; left < nums.length; left++) {
            if (nums[left] % 2 != 0) {
                continue;
            }
            for (int right = left + 1; right < nums.length + 1; right++) {
                int[] subArr = Arrays.copyOfRange(nums, left, right);
                if (subArr.length < maxSubArrayLength) {
                    continue;
                } else {
                    if (arrMatchesConditions(subArr, threshold)) {
                        if (subArr.length > maxSubArrayLength) {
                            maxSubArrayLength = subArr.length;
                        }
                    }
                }
            }
        }

        System.out.println("ans = " + maxSubArrayLength);
        return maxSubArrayLength;
    }

    private boolean arrMatchesConditions(int[] subArr, int threshold) {
        int previousMod = -42;
        for (int i = 0; i < subArr.length; i++) {
            if (subArr[i] > threshold) {
                return false;
            }

            if (previousMod == -42) {
                previousMod = subArr[i] % 2;
                if (previousMod != 0) {
                    return false;
                }
            } else {
                int currMod = subArr[i] % 2;
                if (previousMod == currMod) {
                    return false;
                }
                previousMod = currMod;
            }
        }
        return true;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestAlternatingSubarray(new int[]{3,2,5,4}, 5);
        sol.longestAlternatingSubarray(new int[]{1,2}, 2);
        sol.longestAlternatingSubarray(new int[]{2,3,4,5}, 4);
        sol.longestAlternatingSubarray(new int[]{1}, 1);  //expected 0
        sol.longestAlternatingSubarray(new int[]{2}, 2);
        sol.longestAlternatingSubarray(new int[]{4}, 2);
    }
}
