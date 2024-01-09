package _Study.Problems.nonoverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 *
 * TODO  : Identical problem, just rephrased , see https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */

class Solution {
//    public int eraseOverlapIntervals(int[][] intervals) {
//
//        // counting number of intervals to remove to make consistent is the same as
//        // counting number of intervals that are consistent.
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
//        int[] dp = new int[intervals.length];
//        dp[0] = 1;
//        int[] previousInterval = intervals[0];
//        for (int i = 1; i < intervals.length; i++) {
//            int[] nextInterval = intervals[i];
//            if (previousInterval[1] <= nextInterval[0]) {
//                dp[i] = dp[i - 1] + 1;
//                previousInterval= nextInterval;
//            } else {
//                dp[i] = dp[i - 1]; // always keep the previousInterval
//            }
//        }
//
//        int ans = intervals.length - dp[intervals.length - 1];
//        System.out.println(ans);
//        return ans;
//    }


    Integer[] dp;
    public int eraseOverlapIntervals(int[][] intervals) {
        dp = new Integer[intervals.length + 1];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int consistentIntervals = maxNumberOfConsistentIntervals(intervals, intervals.length - 1);
        int ans = intervals.length - consistentIntervals;
        System.out.println(ans);
        return ans;
    }

    private int maxNumberOfConsistentIntervals(int[][] intervals, int index) {
        if (index <= 0) {
            return 1;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int[] currInterval = intervals[index];

        int exclusiveScore = maxNumberOfConsistentIntervals(intervals, index - 1);
        int inclusiveScore = Integer.MAX_VALUE;
        for (int i = index - 1; i >= 0 ; i--) {
            int[] prevInterval = intervals[i];
            if (prevInterval[1] > currInterval[0]) {
                continue;
            } else {
                inclusiveScore = maxNumberOfConsistentIntervals(intervals, i) + 1;
                break;
            }
        }
        if (inclusiveScore == Integer.MAX_VALUE) { // every previous interval overlaps with this one.
            inclusiveScore = 1; // we remove everything except the current interval
        }

        int ans = Math.max(inclusiveScore, exclusiveScore);
        dp[index] = ans;
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
        sol.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}});
        sol.eraseOverlapIntervals(new int[][]{{1,2},{2,3}});
        sol.eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}});
    }
}