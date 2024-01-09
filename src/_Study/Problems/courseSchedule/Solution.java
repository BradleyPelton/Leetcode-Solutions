package _Study.Problems.courseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/description/
 *
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return false;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canFinish(
                2,
                new int[][]{{1,0}}
        );
        sol.canFinish(
                2,
                new int[][]{{1,0},{0,1}}
        );
        sol.canFinish(
                5,
                new int[][]{{1,4},{2,4},{3,1},{3,2}}
        );
        sol.canFinish(
                3,
                new int[][]{{2,1},{3,2},{1,3}}
        );

        // TLE IN Submission
    }
}
