package contests.contests2024.lc0525biweekly.easy;

import java.util.HashMap;
import java.util.Map;

// Accepted first try
// Accepted after 4 minutes
// Brute force. I'm sure theres a clever XOR solution

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int currXOR = nums[0];

        //1100
        //0011


        // XOR everything will yield the XOR of the single occs.
        for (int i = 1; i < nums.length; i++) {
            currXOR ^= nums[i];
        }

        int oneXOR = currXOR;
        int diffXOR = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((oneXOR ^ nums[i]) != 0 && (diffXOR ^ nums[i]) != diffXOR) { // then number repeats twice
                if (ans == Integer.MAX_VALUE) {
                    ans = nums[i];
                } else {
                    ans ^= nums[i];
                }
            }
            diffXOR ^= nums[i];
        }

        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }

        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.duplicateNumbersXOR(
//                new int[]{1,2,1,3}
//        );
//        sol.duplicateNumbersXOR(
//                new int[]{1,2,3}
//        );
        sol.duplicateNumbersXOR(
                new int[]{1,2,2,1}
        );




    }
}
