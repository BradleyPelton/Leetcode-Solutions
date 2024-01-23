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
 *     Connected Components Approach: // TODO -
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
//    public int[][] merge(int[][] intervals) {
        // TODO - CONNECTED COMPONENTS
        // Basically the brute force solution. Still O(n**2). See mergeSorted for
//        return null;
//    }

    public int[][] merge(int[][] intervals) { // Sorting - 20% runtime, 16% memory
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ansList = new ArrayList<>();

        int[] currInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (currInterval[1] >= intervals[i][1]) { // proper containment
                continue;
            } else if (currInterval[1] >= intervals[i][0] && currInterval[1] < intervals[i][1]) { // overlap
                currInterval[1] = intervals[i][1];
            } else { // disjoint
                ansList.add(currInterval);
                currInterval = intervals[i];
            }
        }
        ansList.add(currInterval);
        int[][] ans = ansList.toArray(new int[ansList.size()][]);
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