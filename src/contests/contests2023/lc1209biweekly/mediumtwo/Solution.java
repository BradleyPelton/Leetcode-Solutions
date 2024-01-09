package contests.contests2023.lc1209biweekly.mediumtwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted after 26 minutes
// Wasted time playing with indices

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (!indexMap.containsKey(val)) {
                indexMap.put(val, new ArrayList<>());
            }
            indexMap.get(val).add(i);

        }

        int left = 0;
        int right = 0;
        Map<Integer, Integer> currOccMap = new HashMap<>();
        currOccMap.put(nums[0], 1);

        int longestSubArray = 1;
        while (left < nums.length) {
            right = Math.max(left, right);
            if (right == nums.length - 1) {
                break;
            }
            right++;
            int val = nums[right];
            int currOccOfVal = currOccMap.getOrDefault(val, 0);
            if (currOccOfVal < k) {
                currOccMap.put(val, currOccOfVal + 1);
            } else { // else currOccVal == k
                // trim left until we lose a num == val
                while (left < nums.length) {
                    int poppedVal = nums[left];
                    if (poppedVal == val) {
                        currOccMap.put(poppedVal, currOccMap.get(poppedVal));
                        left++;
                        break;
                    } else {
                        left++;
                        currOccMap.put(poppedVal, currOccMap.get(poppedVal) - 1);
                    }
                }
            }
            int currLength = right - left + 1;
            longestSubArray = Math.max(longestSubArray, currLength);
        }
        System.out.println(longestSubArray);
        return longestSubArray;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxSubarrayLength(
                new int[]{1,2,3,1,2,3,1,2},
                2
        );
        sol.maxSubarrayLength(
                new int[]{1,2,1,2,1,2,1,2},
                1
        );
        sol.maxSubarrayLength(
                new int[]{5,5,5,5,5,5,5},
                4
        );
        sol.maxSubarrayLength(
                new int[]{1},
                1
        );  // 1
    }
}
