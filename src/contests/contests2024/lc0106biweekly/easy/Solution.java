package contests.contests2024.lc0106biweekly.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Accepeted after second attempt
// Accepted after 9 m,inutes
// WTF BUG???? [9,10] is sequential...

class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        List<Integer> seqSums = new ArrayList<>();

        int largestSequentialSum = 0;
        for (int i = 0; i < n; i++) {
            int currSum = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[j - 1] + 1) {
                    currSum += nums[j];
                } else {
                    break;
                }
            }
            seqSums.add(currSum);
        }


        int smallestMax = 0;
        Arrays.sort(nums);
        OUTER_LOOP:
        for (int sum : seqSums) {
            smallestMax = sum;
            while (true) {
                if (Arrays.binarySearch(nums, smallestMax) >= 0) {
                    smallestMax++;
                } else {
                    break OUTER_LOOP;
                }
            }
        }

        System.out.println(smallestMax);
        return smallestMax;
    }
}





class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.missingInteger(new int[]{1,2,3,2,5}); // 6
        sol.missingInteger(new int[]{3,4,5,1,12,14,13}); // 15
        sol.missingInteger(new int[]{14,9,6,9,7,9,10,4,9,9,4,4}); // expected 15

    }
}
