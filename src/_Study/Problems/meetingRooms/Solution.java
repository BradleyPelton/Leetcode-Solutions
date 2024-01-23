package _Study.Problems.meetingRooms;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) { // Sort - 33% runtime, 32% memory
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // sort by start time

        int lastEndTime = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < lastEndTime) {
                return false;
            }
            lastEndTime = interval[1];
        }
        return true;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canAttendMeetings(new int[][]{{0,30},{5,10},{15,20}});
        sol.canAttendMeetings(new int[][]{{7,10},{2,4}});
        sol.canAttendMeetings(new int[][]{{13,15},{1,13}});
        sol.canAttendMeetings(new int[][]{{0,30},{60,240},{90,120}});
        sol.canAttendMeetings(new int[][]{{}});
    }
}
