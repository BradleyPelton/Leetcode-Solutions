package _Study.Problems.meetingRooms2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        return -42;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.minMeetingRooms(
//                new int[][]{{0,30},{5,10},{15,20}}
//        ); // 2
//        sol.minMeetingRooms(
//                new int[][]{{7,10},{2,4}}
//        ); // 1
//        sol.minMeetingRooms(
//                new int[][]{{13,15},{1,13}}
//        ); // 1
//        sol.minMeetingRooms(
//                new int[][]{{9,10},{4,9},{4,17}}
//        ); // 2
        sol.minMeetingRooms(
                new int[][]{{2,11},{6,16},{11,16}}
        ); // 2
    }
}