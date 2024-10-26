package contests.contests2024.lc1012biweekly.easy;

import java.util.Arrays;
import java.util.List;

// Accepted after 6 minutes
// Accepted first attempt

// Intense easy problem. Brute force worked.

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        int[] ans = new int[n];
        OUTER_LOOP:
        for (int i = 0; i < n; i++) {
            int target = nums.get(i);
            for (int j = 0; j < 10000; j++) {
                int val = j | (j + 1);
                if (val == target) {
                    ans[i] = j;
                    continue OUTER_LOOP;
                }
            }
            ans[i] = -1;
        }
//        System.out.println(Arrays.toString(ans));
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minBitwiseArray(List.of(2,3,5,7));
        sol.minBitwiseArray(List.of(11,13,31));



    }
}