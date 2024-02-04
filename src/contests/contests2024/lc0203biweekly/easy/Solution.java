package contests.contests2024.lc0203biweekly.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

// Accepted after 7 minutes
// Dumb Question - Didn't specicy rules of triangle
// 3 wrong answer. carelessness.

class Solution {
    public String triangleType(int[] nums) {

        String ans;
        Arrays.sort(nums);
        if (nums[2] >= nums[1] + nums[0]) {
            ans = "none";
        } else {
            if (nums[0] == nums[1] && nums[0] == nums[2]) {
                ans = "equilateral";
            } else if (nums[0] == nums[1]) {
                ans = "isosceles";
            } else if (nums[1] == nums[2]) {
                ans = "isosceles";
            } else if (nums[0] == nums[2]) {
                ans = "isosceles";
            } else {
                ans = "scalene";
            }
        }
        System.out.println(ans);
        return ans;
    }
}







class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.triangleType(new int[]{3,3,3});
        sol.triangleType(new int[]{3,4,5});
        sol.triangleType(new int[]{8,4,2}); // none
        sol.triangleType(new int[]{5,3,8}); // none
        sol.triangleType(new int[]{8,4,4});   // none





    }
}
