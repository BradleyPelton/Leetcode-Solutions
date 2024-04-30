package contests.contests2024.lc0427.easy;

import java.util.Arrays;

// Accepted after 3 minutes
// Trivial

class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ans = nums2[0] - nums1[0];
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.addedInteger(
                new int[]{2,6,4},
                new int[]{9,7,5}
        );
        sol.addedInteger(
                new int[]{10},
                new int[]{5}
        );
        sol.addedInteger(
                new int[]{1,1,1,1},
                new int[]{1,1,1,1}
        );





    }
}
