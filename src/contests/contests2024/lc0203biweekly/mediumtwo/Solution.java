package contests.contests2024.lc0203biweekly.mediumtwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// First attempt TLE
// I knew it. HashMap was not going to work. Why did I waste 20 minutes doing it.

class Solution {
//    public long maximumSubarraySum(int[] nums, int k) {
//
//
//
//        // Worst case
//        // {1,2,1,2,1,2,1,2,1,2}
//        // We can't choose the first and last since there might be negative numbers between
//        //
//
//        int n = nums.length;
//
//        long currSum = 0;
//        long maxSum = Long.MIN_VALUE;
//        int left = 0;
//        for (int right = 0; right < n; right++) {
//            currSum += nums[right];
//            if (currSum <= ) {
//                left = right + 1;
//                currSum = 0;
//                continue;
//            }
//            if (Math.abs(nums[left] - nums[right]) == k) {
//                maxSum = Math.max(currSum, maxSum);
//            }
//        }
//
//        if (maxSum == Long.MIN_VALUE) {
//            maxSum = 0;
//        }
//        System.out.println(maxSum);
//        return maxSum;
//    }


    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        Map<Integer, List<Integer>> occMap = new HashMap<>();
        occMap.put(nums[0], new ArrayList<>(List.of(0)));
        for (int i = 1; i < n; i++) {
            occMap.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        long maxSum = Long.MIN_VALUE;
        for (int key : occMap.keySet()) {
            List<Integer> regularIndices = occMap.get(key);

            if (occMap.containsKey(key - k)) {
                List<Integer> complementIndices = occMap.get(key - k);
                for (int regularIndex : regularIndices) {

                    int lastComplement = complementIndices.get(complementIndices.size() - 1);
                    long previousSum;
                    if (lastComplement < regularIndex) {
                        if (lastComplement == 0) {
                            previousSum = prefixSum[regularIndex];
                        } else {
                            previousSum = prefixSum[regularIndex] - prefixSum[lastComplement - 1];
                        }
                    } else {
                        if (regularIndex == 0) {
                            previousSum = prefixSum[lastComplement];
                        } else {
                            previousSum = prefixSum[lastComplement] - prefixSum[regularIndex - 1];
                        }
                    }

                    maxSum = Math.max(maxSum, previousSum);





                    // [regular, ..., complement, ..., previousComplement]

                    // if (sum[complement..previousComplement] < 0 )
                    // then the sum[regular..complement] < sum[regular..previousComplement]

                    for (int i = complementIndices.size() - 2; i >= 0; i--) {
                        int complementIndex = complementIndices.get(i);
                        if (complementIndex < regularIndex) {
                            if (complementIndex == 0) {
                                maxSum = Math.max(maxSum, prefixSum[regularIndex]);
                            } else {
                                maxSum = Math.max(maxSum, prefixSum[regularIndex] - prefixSum[complementIndex - 1]);
                            }
                        } else {
                            if (regularIndex == 0) {
                                maxSum = Math.max(maxSum, prefixSum[complementIndex]);
                            } else {
                                maxSum = Math.max(maxSum, prefixSum[complementIndex] - prefixSum[regularIndex - 1]);
                            }
                        }
                    }
                }
            }
            if (occMap.containsKey(key + k)) {
                List<Integer> complementIndices = occMap.get(key + k);
                for (int regularIndex : regularIndices) {
                    for (int complementIndex : complementIndices) {
                        if (complementIndex < regularIndex) {
                            if (complementIndex == 0) {
                                maxSum = Math.max(maxSum, prefixSum[regularIndex]);
                            } else {
                                maxSum = Math.max(maxSum, prefixSum[regularIndex] - prefixSum[complementIndex - 1]);
                            }
                        } else {
                            if (regularIndex == 0) {
                                maxSum = Math.max(maxSum, prefixSum[complementIndex]);
                            } else {
                                maxSum = Math.max(maxSum, prefixSum[complementIndex] - prefixSum[regularIndex - 1]);
                            }
                        }
                    }
                }
            }
        }

        if (maxSum == Long.MIN_VALUE) {
            maxSum = 0;
        }
        System.out.println(maxSum);
        return maxSum;
    }
}






class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumSubarraySum(
                new int[]{1,2,3,4,5,6},
                1
        ); // 11
        sol.maximumSubarraySum(
                new int[]{-1,3,2,4,5},
                3
        ); // 11
        sol.maximumSubarraySum(
                new int[]{-1,-2,-3,-4},
                2
        ); // -6







    }
}
