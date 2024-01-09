package contests.contests2023.lc0211.mediumone;

import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {

        if (nums.length == 0 || nums.length == 1) {
            return 0L;
        }

        /// 1, 2*, 3, 4, 5, [6, 7, 8], 9, 10

        Arrays.sort(nums);
        // 0, 1, 4, 4, 5, 7
        // 3 <= i + j <= 6

        long numberOfGoodPairs = 0;

        int leftIndex = 0;
        while (true) {
            int numsLeft = nums[leftIndex];
            if (numsLeft > upper) {
                break;
            }

            int maxValueRight = upper - numsLeft;
            int minValueRight = lower - numsLeft;

            int indexOfMin = Arrays.binarySearch(nums, minValueRight);
            if (indexOfMin < 0) {
                //-(insertion point) - 1
                indexOfMin++;
                indexOfMin *= -1;
            }
            if (indexOfMin == nums.length) {
                leftIndex++;
                continue;
            }
            while (indexOfMin > leftIndex  && indexOfMin > 0 && nums[indexOfMin] == nums[indexOfMin - 1]) {
                indexOfMin--;
            }

            int indexOfMax = Arrays.binarySearch(nums, maxValueRight);
            if (indexOfMax < 0) {
                //-(insertion point) - 1
                indexOfMax++;
                indexOfMax *= -1;
                indexOfMax--;
            }
            if (indexOfMax < leftIndex) {
                break;
            }
            while (indexOfMax < nums.length - 1 && nums[indexOfMax] == nums[indexOfMax+1]) {
                indexOfMax++;
            }

            numberOfGoodPairs += indexOfMax - indexOfMin + 1;
            leftIndex++;
        }

        System.out.println("ans = " + numberOfGoodPairs);
        return numberOfGoodPairs;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countFairPairs(new int[]{0,1,7,4,4,5}, 3 , 6); // 6
        sol.countFairPairs(new int[]{1,7,9,2,5}, 11 , 11); // 1
        sol.countFairPairs(new int[]{0,0,0,0,0,0}, 0, 0); // 15
        sol.countFairPairs(new int[]{0,0,0,0,0,0}, 0, 0); // 15
    }
}