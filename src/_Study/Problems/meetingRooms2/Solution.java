package _Study.Problems.meetingRooms2;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // max number of meeting rooms is equivalent to:
        // max number of overlapping intervals at any given time t


        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //  sort by start time

        int maxNumberOfMeetingRooms = 1;
        System.out.println(maxNumberOfMeetingRooms);
        return maxNumberOfMeetingRooms;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minMeetingRooms(
                new int[][]{{0,30},{5,10},{15,20}}
        );
        sol.minMeetingRooms(
                new int[][]{{7,10},{2,4}}
        );
    }
}