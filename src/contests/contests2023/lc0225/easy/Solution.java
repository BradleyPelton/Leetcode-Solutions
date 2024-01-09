package contests.contests2023.lc0225.easy;

import java.util.Arrays;

// Acceptted after 5 miuntes
// trivial

class Solution {
    public int[] leftRigthDifference(int[] nums) {

        int rightSum = Arrays.stream(nums).sum();
        int leftSum = 0;

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            int diff = Math.abs(rightSum - leftSum);
            ans[i] = diff;
            leftSum += nums[i];
        }

//        System.out.println(Arrays.toString(ans));
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.leftRigthDifference(new int[]{10,4,8,3});
        sol.leftRigthDifference(new int[]{1});
    }
}
