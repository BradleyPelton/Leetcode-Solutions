package _Study.Problems.insertIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/description/
 *
 * // TODO - Binary Search Insert
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) { // Linear Insert - 10% runtime, 52% memory
        // NOTE: intervals arr is already sorted by a -> a[0]
        List<int[]> ansList = new ArrayList<>();
        boolean alreadyInserted = false;
        for (int[] interval : intervals) {
            if (alreadyInserted) { // everything after
                ansList.add(interval);
            } else if (interval[1] < newInterval[0]) { // everything before
                ansList.add(interval);
            } else if (interval[0] > newInterval[1]) { // the next interval is after, but we havn't inserted yet
                ansList.add(newInterval);
                ansList.add(interval);
                alreadyInserted = true;
            } else { // else overlap exists
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (!alreadyInserted) { // inserted interval is overlapping end or completely after end
            ansList.add(newInterval);
        }
        int[][] ans = ansList.toArray(new int[ansList.size()][]);
        System.out.println(Arrays.deepToString(ans));
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.insert(
                new int[][]{{1,3},{6,9}},
                new int[]{2,5}
        ); // [[1,5],[6,9]]
        sol.insert(
                new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},
                new int[]{4,8}
        ); // [[1,2],[3,10],[12,16]]
    }
}
