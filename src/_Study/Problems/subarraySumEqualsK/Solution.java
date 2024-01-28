package _Study.Problems.subarraySumEqualsK;


import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k
 *
 * <p>
 * This is a cool example of an advanced prefix sum pattern.
 * A standard prefix sum approach works, but the prefixSum + occMap pattern is much faster.
 * </p>
 */
class Solution {
//    public int subarraySum(int[] nums, int k) { // Prefix Sum - 12% runtime, 91% memory
//        int n = nums.length;
//        int[] prefixSum = new int[n + 1];
//        prefixSum[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
//        }
//
//        int ans = 0;
//        for (int i = 0; i <= n; i++) {
//            for (int j = i + 1; j <= n ; j++) {
//                int currSum = prefixSum[j] - prefixSum[i];
//                if (currSum == k) {
//                    ans++;
//                }
//            }
//
//        }
//
//        System.out.println(ans);
//        return ans;
//    }

    public int subarraySum(int[] nums, int k) { // TODO - Submit and evaluate runtime. Should work fine.
        int n = nums.length;
        Map<Integer, Integer> prefixOcc = new HashMap<>();
        prefixOcc.put(0, 1); // empty set has a sum of zero

        int ans = 0;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            int complement = currSum - k;
            if (prefixOcc.containsKey(complement)) {
                ans += prefixOcc.get(complement);
            }
            prefixOcc.put(currSum, prefixOcc.getOrDefault(currSum, 0) + 1);
        }

        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.subarraySum(
                new int[]{1,1,1},
                2
        );
        sol.subarraySum(
                new int[]{1,2,3},
                3
        );
    }
}
