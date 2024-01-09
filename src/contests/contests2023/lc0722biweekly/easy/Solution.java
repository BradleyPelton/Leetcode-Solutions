package contests.contests2023.lc0722biweekly.easy;

import java.util.Arrays;

// accepted after 5 minutes
// two incorrect answers. stupid edge case.

class Solution {
    public boolean isGood(int[] nums) {

        if (nums.length == 1) {
            System.out.println("trivial bad");
            return false;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] != nums[i -1]) {
                    System.out.println("problem last element");
                    return false;
                }

            } else {
                if (nums[i] != i + 1) {
                    System.out.println("problem at i = " + i);
                    return false;
                }
            }
        }
        System.out.println("no problems");
        return true;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isGood(new int[]{2, 1, 3});
        sol.isGood(new int[]{1, 3, 3, 2});
        sol.isGood(new int[]{1, 1});
        sol.isGood(new int[]{3, 4, 4, 1, 2, 1});
        sol.isGood(new int[]{1});
        sol.isGood(new int[]{0});
    }
}