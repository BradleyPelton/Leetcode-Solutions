package contests.contests2024.lc0706biweekly.hard;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] leftPrefixAnd = new int[n];
        leftPrefixAnd[0] = nums[0];

        for (int i = 1; i < n; i++) {
            leftPrefixAnd[i] = leftPrefixAnd[i - 1] & nums[i];
        }

        int[] rightPrefixAnd = new int[n];
        rightPrefixAnd[n - 1] = nums[n];
        for (int i = n - 2; i >= 0; i--) {
            rightPrefixAnd[i] = rightPrefixAnd[i + 1] & nums[i];
        }


        Map<Integer, Integer> prefixSeenBefore =  new HashMap<>();


        long ans = 0;
        if (nums[0] == k) {
            ans++;
        }
        int currPrefix = nums[0];
        prefixSeenBefore.put(currPrefix, 1);
        for (int i = 1; i < n; i++) {
            currPrefix = currPrefix & nums[i];


            int complement = k ^ currPrefix;
            System.out.println("sdfasdf");
//            for (int index = 0; index < 32; index++) {
//                int currBitInPrefix = (currPrefix & (1 << (index)))  == 0 ? 0 : 1;
//                if (k & (1 << (index)) == 0) {
//                } else {
//                }
//            }


            // complement such that:
            // currPrefix & complement == k

        }


        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countSubarrays(
                new int[]{1,1,1},
                1
        );
        sol.countSubarrays(
                new int[]{1,1,2},
                1
        );
        sol.countSubarrays(
                new int[]{1,2,3},
                2
        );
    }
}
