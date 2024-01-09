package contests.contests2023.lc0408.mediumone;

import java.util.*;

class Solution {
    public long[] distance(int[] nums) {

        Map<Long, Long> sumOfIndicesMap = new HashMap<>();
        Map<Long, Integer> occMap = new HashMap<>();

        long[] sumOfIndicesSoFar = new long[nums.length];
        int[] occSoFar = new int[nums.length];


        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];
            long currSum;
            int currOcc;
            if (sumOfIndicesMap.containsKey(val)) {
                // count sum of indices
                currSum = sumOfIndicesMap.get(val);
                currSum += i;

                // count occ
                currOcc = occMap.get(val);
                currOcc += 1;
            } else {
                currSum = i;
                currOcc = 1;
            }
            sumOfIndicesMap.put(val, currSum);
            sumOfIndicesSoFar[i] = currSum;

            occMap.put(val, currOcc);
            occSoFar[i] = currOcc;
        }

        long[] ans = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];
            long totalSum = sumOfIndicesMap.get(val);
            int totalOcc = occMap.get(val);

            if (totalOcc == 1) {
                ans[i] = 0;
                continue;
            }

            long sumBeforeExcluding = sumOfIndicesSoFar[i] - val;


            ans[i] =  totalSum - (totalOcc - occSoFar[i]) * val  +  (occSoFar[i] * val) - sumBeforeExcluding;
        }

        System.out.println(Arrays.toString(ans));
        return ans;


    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.distance(new int[]{1,3,1,1,2});
        sol.distance(new int[]{0,5,3});
    }
}
