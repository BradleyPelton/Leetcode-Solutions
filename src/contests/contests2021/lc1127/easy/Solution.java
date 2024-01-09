package contests.contests2021.lc1127.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Accepted after 3 minutes

// Trivial

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {


        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans.add(i);
            }
        }

        System.out.println(ans);
        return ans;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.targetIndices(new int[]{1,2,5,2,3}, 2);
        sol.targetIndices(new int[]{1,2,5,2,3}, 3);
        sol.targetIndices(new int[]{1,2,5,2,3}, 5);
        sol.targetIndices(new int[]{1,2,5,2,3}, 4);
    }
}
