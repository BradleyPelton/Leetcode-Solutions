package contests.contests2024.lc1109biweekly.mediumone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// First attempt wrong answer

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;

        int ans = 1;
        Arrays.sort(nums);

        Map<Integer, Integer> occMap = new HashMap<>();
        int prevRight = 0;
        for (int left = 0; left < n; left++) {
            if (left > 0) {
                occMap.remove(nums[left - 1]);
            }

            occMap.put(nums[left], occMap.getOrDefault(nums[left], 0) + 1);

            // Count the number of overlapping intervals with [arr[left], arr[left + k]
            int localMax = nums[left] + k;
            int right = prevRight;
            while (true) {
                if (right == n - 1) {
                    break;
                }

                if (nums[right + 1] - k > localMax) {
                    break;
                } else {
                    right++;
                    occMap.put(nums[right], occMap.getOrDefault(nums[right], 0) + 1);
                }
            }

            // Every interval between [left, right] can be squished


            // Most frequent numbers in [left, right] ?
            int maxFrequencyKey = -1;
            int maxFrequencyVal = -1;
            for (int key : occMap.keySet()) {
                int val = occMap.get(key);
                if (val > maxFrequencyVal) {
                    maxFrequencyKey = key;
                    maxFrequencyVal = val;
                }
            }

            int localAns = Math.min(
                    right - left + 1,  // can't exceed size of window
                    maxFrequencyVal + numOperations
            );

            ans = Math.max(ans, localAns);
            prevRight = right;


            while (left < n - 1 && nums[left] == nums[left + 1]) {
                left++;
            }

        }
        System.out.println(ans);
        return ans;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.maxFrequency(
//                new int[]{1,4,5},
//                1,
//                2
//        );
        sol.maxFrequency(
                new int[]{5,11,20,20},
                5,
                1
        ); // 2
//        sol.maxFrequency(
//                new int[]{88,53},
//                27,
//                2
//        ); // 2


    }
}