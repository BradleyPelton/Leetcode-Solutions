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
    Map<Integer, List<Integer>> requiresMap;
    int numCourses;
    boolean[] seen;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        requiresMap = new HashMap<>();
        for (int[] edge : prerequisites) {
            requiresMap.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            seen = new boolean[numCourses];
            if (!canCompleteCourse(course)) {
                System.out.println("false, problem at course = " + course);
                return false;
            }
        }

        System.out.println("true, all good");
        return true;
    }

    public boolean canCompleteCourse(int course) {
        if (seen[course]) {
            return false;
        }
        seen[course] = true;

        if (requiresMap.containsKey(course)) { // if course has prereqs
            List<Integer> currCoursePrereqs = requiresMap.get(course);
            for (int prereq : currCoursePrereqs) {
                boolean canCompletePrereq = canCompleteCourse(prereq);
                if (!canCompletePrereq) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.canFinish(
//                2,
//                new int[][]{{1,0}}
//        );
//        sol.canFinish(
//                2,
//                new int[][]{{1,0},{0,1}}
//        );
//        sol.canFinish(
//                4,
//                new int[][]{{0,1},{3,1},{1,3},{3,2}}
//        );
        sol.canFinish(
                5,
                new int[][]{{1,4},{2,4},{3,1},{3,2}}
        );
//        sol.canFinish(
//                3,
//                new int[][]{{1,0},{0,2},{2,1}}
//        );
        // TLE IN Submission
    }
}
