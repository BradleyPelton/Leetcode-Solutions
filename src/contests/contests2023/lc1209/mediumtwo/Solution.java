package contests.contests2023.lc1209.mediumtwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


// 8 wrong answers in a row. Sloppy handling of edge cases. Submitting as soon as test cases pass. Sloppy.

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int maxOcc = 0;
        int[] maxValSoFar = new int[n];
        Map<Integer, Integer> firstOccMap = new HashMap<>();
        if (nums[0] == maxVal) {
            maxOcc++;
            maxValSoFar[0] = 1;
            firstOccMap.put(1, 0);
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == maxVal) {
                maxOcc++;
                firstOccMap.put(maxOcc, i);
            }
            maxValSoFar[i] = maxOcc;
        }

        Set<List<Integer>> goodArrs = new HashSet<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int maxBefore = 0;
            if (i != 0) {
                maxBefore = maxValSoFar[i - 1];
            }

            int maxNeeded = k + maxBefore;
            if (firstOccMap.containsKey(maxNeeded)) {
                int firstIndex = firstOccMap.get(maxNeeded);
                if (firstIndex < 0 || firstIndex < i || firstIndex > n - 1) {

                } else {
                    //i,...,firstIndex == k
                    int numberOfGoodSubArrays = n - firstIndex;
                    ans += numberOfGoodSubArrays;
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
}






class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.countSubarrays(
//                new int[]{1,3,2,3,3},
//                2
//        ); // 6
//        sol.countSubarrays(
//                new int[]{1,4,2,1},
//                3
//        ); // 0
//        sol.countSubarrays(
//                new int[]{28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49},
//                1
//        );  // 187
//        sol.countSubarrays(
//                new int[]{21,11,13,15,16,21,8,9,6,21},
//                2
//        );  // 10
//
//        sol.countSubarrays(
//                new int[]{73,54,15,4,23,70,53,65,73,73,2,72,36,71,73,69,35,18,62,73,62,73,73,50,30,73,20,71,60,9,12,57,48,73,40,20,8,73,73,73,34,59,31,49,73,5,51,36,47,38,36,58,34,42,23,28,52,73},
//                1
//        );  // 1537
//        sol.countSubarrays(
//                new int[]{1,1,1,1,1,1,1,1,1,1},
//                1
//        );  // 55
//        sol.countSubarrays(
//                new int[]{3},
//                1
//        );  // 1
//        sol.countSubarrays(
//                new int[]{3},
//                2
//        );  // 0
        sol.countSubarrays(
                new int[]{3,3,3,3,3,3},
                5
        );  // 0

    }
}
