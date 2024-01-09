package _Study.Problems.mergeIntervalsTODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description
 *
 * <p>
 *     Connected Components Approach:
 *     Time Complexity: Big O(n**2)
 *     Space Comlexity: Big O(n**2)
 * </p>
 *
 * <p>
 *     Sorting Approach:
 *     Time Compelxity: Big O( n log n) - sorting the list of arrays is the most expensive operation
 *     Space Complexity: Big O (log n) - The space consumed by sorting (depends on language)
 * </p>
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        // CONNECTED COMPONENTS
        // Basically the brute force solution. Still O(n**2). See mergeSorted for
        return null;
    }

    public int[][] mergeSORTED(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] previousInterval = mergedIntervals.remove(mergedIntervals.size() - 1);
            int[] currentInterval = intervals[i];

            if (previousInterval[1] >= currentInterval[0]) {
                if (previousInterval[1] >= currentInterval[1]) { // proper containment
                    mergedIntervals.add(previousInterval);
                } else {
                    int[] newInterval = new int[]{previousInterval[0], currentInterval[1]};
                    mergedIntervals.add(newInterval);
                }
            } else { // else no overlap
                mergedIntervals.add(previousInterval);
                mergedIntervals.add(currentInterval);
            }
        }

        int[][] ans = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            ans[i] = mergedIntervals.get(i);
        }
        System.out.println(Arrays.deepToString(ans));
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        sol.merge(new int[][]{{1,4},{4,5}});


    }
}