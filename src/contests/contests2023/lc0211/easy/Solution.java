package contests.contests2023.lc0211.easy;

import java.util.Arrays;

// Accepted first try
// Accepted after 7 minutes

// Took longer to read the problem then implement

class Solution {
    public long findTheArrayConcVal(int[] nums) {

        long concatValue = 0;

        while(nums.length != 0) {
            if (nums.length == 1) {
                concatValue += nums[0];
                break;
            } else {
                int firstEle = nums[0];
                int lastEle = nums[nums.length - 1];
                long cValue = Long.valueOf(String.valueOf(firstEle) + String.valueOf(lastEle));
                concatValue += cValue;
                if (nums.length == 2) {
                    nums = new int[]{};
                } else {
                    nums = Arrays.copyOfRange(nums, 1, nums.length - 1);
                }
            }
        }

        System.out.println("ans = " + concatValue);
        return concatValue;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findTheArrayConcVal(new int[]{7,52,2,4});
        sol.findTheArrayConcVal(new int[]{5,14,13,8,12});
    }
}
