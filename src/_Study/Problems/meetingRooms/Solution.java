package _Study.Problems.meetingRooms;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // NOTE: You can sort by start or end time here. Only in the more complex case is the sorted and looping order matter.

        int[] prevInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (prevInterval[1] > nextInterval[0]) {
                return false;
            }
            prevInterval = nextInterval;
        }
        return true;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.canAttendMeetings(new int[][]{{0,30},{5,10},{15,20}});
//        sol.canAttendMeetings(new int[][]{{7,10},{2,4}});
//        sol.canAttendMeetings(new int[][]{{13,15},{1,13}});
        sol.canAttendMeetings(new int[][]{{0,30},{60,240},{90,120}});
    }

    public static boolean overlap(int[] int1, int[] int2) {
        return Math.min(int1[1], int2[1]) > Math.max(int1[0], int2[0]);
    }
}
