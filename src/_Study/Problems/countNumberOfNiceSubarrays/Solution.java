package _Study.Problems.countNumberOfNiceSubarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1248. Count Number of Nice Subarrays
 * https://leetcode.com/problems/count-number-of-nice-subarrays/description/
 *
 * There's a trivial sliding window approach that is easy to implement with O(n) space.
 *
 * This problem is a great example of an Advanced Prefix algorithm though.
 * Also see https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) { // Advanced Prefix Algorithm
        int n = nums.length;
        Map<Integer, Integer> occsSeen = new HashMap<>();
        occsSeen.put(0, 1); // empty set has zero numOfOdds

        int ans = 0;
        int numOfOdds = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                numOfOdds++;
            }

            int complement = numOfOdds - k;
            if (occsSeen.containsKey(complement)) {  // if complement is negative, it will never have been seen
                ans += occsSeen.get(complement);
            }
            occsSeen.put(numOfOdds, occsSeen.getOrDefault(numOfOdds, 0) + 1);
        }
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numberOfSubarrays(
                new int[]{1,1,2,1,1},
                3
        );
        sol.numberOfSubarrays(
                new int[]{2,4,6},
                1
        );
        sol.numberOfSubarrays(
                new int[]{2,2,2,1,2,2,1,2,2,2},
                2
        );
    }
}
