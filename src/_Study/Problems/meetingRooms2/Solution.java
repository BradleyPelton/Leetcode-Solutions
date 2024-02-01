package _Study.Problems.meetingRooms2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 253. Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii
 *
 *
 * // TODO - Heap solution is much simpler
 * // TODO - Two Pointer solution
 *
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) { // Heap - 14% runtime, 32% memory
        int n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] b) -> -b[1]));

        Queue<int[]> intervalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // smallest end time
        // Everything in the heap must necessarily have a smaller start time.
        // If the interval at the top of the heap overlaps with the next interval, everything else in the heap will overlap.
        // This is because every non-top element in the heap has a larger end time (but any range of value for start time)

        int maxHeapSize = 0;
        for (int i = 0; i < n; i++) {
            int[] currInterval = intervals[i];

            // The current time is currInterval[0];
            while (!intervalHeap.isEmpty()) {
                int[] topInterval = intervalHeap.peek();
                if (topInterval[1] <= currInterval[0]) {
                    intervalHeap.remove();
                } else {
                    break;
                }
            }
            intervalHeap.add(currInterval);

            maxHeapSize = Math.max(maxHeapSize, intervalHeap.size());
        }
        System.out.println(maxHeapSize);
        return maxHeapSize;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minMeetingRooms(
                new int[][]{{0,30},{5,10},{15,20}}
        ); // 2
        sol.minMeetingRooms(
                new int[][]{{7,10},{2,4}}
        ); // 1
        sol.minMeetingRooms(
                new int[][]{{13,15},{1,13}}
        ); // 1
        sol.minMeetingRooms(
                new int[][]{{9,10},{4,9},{4,17}}
        ); // 2
        sol.minMeetingRooms(
                new int[][]{{2,11},{6,16},{11,16}}
        ); // 2
    }
}