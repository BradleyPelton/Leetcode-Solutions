package contests.contests2023.lc0610.easy;

import java.util.Arrays;

// Accepted after 2 minutes
// Trivial

class Solution {
    public int findNonMinOrMax(int[] nums) {

        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        int ans = -1;
        for (int e : nums) {
            if (e != min && e != max) {
                ans = e;
                break;
            }
        }

        System.out.println("ans = " + ans);
        return ans;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findNonMinOrMax(new int[]{3,2,1,4});
        sol.findNonMinOrMax(new int[]{1,2});
        sol.findNonMinOrMax(new int[]{2,1,3});

    }
}
