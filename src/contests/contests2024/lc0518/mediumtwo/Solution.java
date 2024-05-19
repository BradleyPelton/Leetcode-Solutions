package contests.contests2024.lc0518.mediumtwo;

import java.util.HashMap;
import java.util.Map;

// First attempt wrong answer
// Second attempt accepted
// Accepted after 15 minutes
// Cool problem. Slipped on long vs int as usual.

class Solution {
    public long sumDigitDifferences(int[] nums) {
        long n = nums.length;

        long ans = 0;

        int numberOfIterations = String.valueOf(nums[0]).length();

        for (int x = 0; x < numberOfIterations; x++) {

            Map<Integer, Long> occCount = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int digit = nums[i] % 10;
                occCount.put(digit, occCount.getOrDefault(digit, 0L) + 1L);
                nums[i] /= 10;
            }

            long numberOfBadPairs = n * (n - 1) / 2;
            for (int digit : occCount.keySet()) {
                long same = occCount.get(digit);
                long samePairs = same * (same - 1) / 2;
                numberOfBadPairs -= samePairs;
            }

            ans += numberOfBadPairs;
        }

        System.out.println(ans);
        return ans;
    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.sumDigitDifferences(
//                new int[]{13,23,12}
//        ); // 4
//        sol.sumDigitDifferences(
//                new int[]{10,10,10,10}
//        ); // 0

        sol.sumDigitDifferences(
                new int[]{41,42,43, 45}
        ); // 0





    }
}