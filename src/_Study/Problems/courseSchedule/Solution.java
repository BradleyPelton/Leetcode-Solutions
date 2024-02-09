package _Study.Problems.courseSchedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/description/
 *
 * Canonical Topological Sort / Kahn's algorithm problem
 *
 *
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) { // Kahn's algorithm - 55% runtime, 30% memory
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            inDegree[prereq[1]]++;
            adjacencyList.get(prereq[0]).add(prereq[1]);
        }

        Deque<Integer> nodesWithZeroInDegree = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                nodesWithZeroInDegree.add(i);
            }
        }

        int numberOfCompletedCourses = 0;
        while (!nodesWithZeroInDegree.isEmpty()) {
            int currNode = nodesWithZeroInDegree.remove();
            numberOfCompletedCourses++;

            for (int neighbor : adjacencyList.get(currNode)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    nodesWithZeroInDegree.add(neighbor);
                }
            }
        }
        return numberOfCompletedCourses == numCourses;
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
                4,
                new int[][]{{0,1},{3,1},{1,3},{3,2}}
        );
        sol.canFinish(
                5,
                new int[][]{{1,4},{2,4},{3,1},{3,2}}
        );
        sol.canFinish(
                3,
                new int[][]{{1,0},{0,2},{2,1}}
        );
        // TLE IN Submission
    }
}
