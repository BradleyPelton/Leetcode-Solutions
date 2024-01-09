package contests.contests2023.lc0715.mediumone;

import java.util.Arrays;

// First attempt TLE

class Solution {
    public int maximumBeauty(int[] nums, int k) {

//        Map<Integer, Integer> availableValuesOcc = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int currNum = nums[i];
//            for (int val = currNum - k; val < currNum + k + 1 ; val++) {
//                availableValuesOcc.put(val, availableValuesOcc.getOrDefault(val, 0) + 1);
//            }
//        }

        Arrays.sort(nums);

        int maxNumberOfVals = 0;
        for (int i = 0; i < nums.length; i++) {
            int centerVal = nums[i];
            int minVal = centerVal - 2 * k;
            int maxVal = centerVal + 2 * k;

            int minLeftPoint = Arrays.binarySearch(nums, minVal);
            if (minLeftPoint < 0) {
                // minVal not found in nums
                minLeftPoint = -minLeftPoint - 1;
            }
            // handle bad insert, fitting left
            while (minLeftPoint < nums.length - 1 && nums[minLeftPoint] < minVal) {
                minLeftPoint++;
            }

            // handle exclusive left, fitting right
            while (minLeftPoint > 0 && nums[minLeftPoint - 1] >= minVal) {
                minLeftPoint++;
            }



            int maxRightPoint = Arrays.binarySearch(nums, maxVal);
            if (maxRightPoint < 0) {
                // maxVal not found in nums
                maxRightPoint = -maxRightPoint - 1;
            }

            if (maxRightPoint > nums.length - 1) {
                maxRightPoint = nums.length - 1;
            }

            // handle bad insert, fitting right
            while (maxRightPoint > 0 && nums[maxRightPoint] > maxVal) {
                maxRightPoint--;
            }

            // handle exclusive right, fitting left
            while (maxRightPoint < nums.length - 1 && nums[maxRightPoint + 1] <= maxVal) {
                maxRightPoint++;
            }


            // LEFT AND RIGHT INCLUSIVE
            int windowLength = maxRightPoint - minLeftPoint + 1;
            maxNumberOfVals = Math.max(maxNumberOfVals, windowLength);

        }

        System.out.println("ans = " + maxNumberOfVals);
        return maxNumberOfVals;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumBeauty(
                new int[]{4,6,1,2},  // 3
                2);
        sol.maximumBeauty(
                new int[]{1,1,1,1},  // 4
                10);
        sol.maximumBeauty(
                new int[]{49,26},  // expected 2;
                12);







    }
}
