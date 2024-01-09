package contests.contests2021.lc0828.easy;

import java.util.Arrays;

// Accepted after 8 minutes

// Seemed intially really challenging, but brute forcing all combinations is trivial

class Solution {
    public int minimumDifference(int[] nums, int k) {

        if (nums.length == 1) {
            System.out.println("dumb 1 case");
            return 0;
        }

        Arrays.sort(nums);

        int absoluteSmallestDifference = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int[] numsSubArr = Arrays.copyOfRange(nums, i, i+k);
//            System.out.println(Arrays.toString(numsSubArr));

            if (numsSubArr.length != k) {
                continue;
            }

            int localMin = Arrays.stream(numsSubArr).min().getAsInt();
            int localMax = Arrays.stream(numsSubArr).max().getAsInt();

            int localDiff = localMax - localMin;

            if (absoluteSmallestDifference > localDiff) {
                absoluteSmallestDifference = localDiff;
            }
        }

        System.out.println("final ans = " + absoluteSmallestDifference);
        return absoluteSmallestDifference;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.minimumDifference(new int[]{9,4,1,7}, 2);


    }
}
