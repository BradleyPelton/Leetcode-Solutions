package _Study.Problems.courseSchedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/description/
 *
 * Canonical Kahn's algorithm problem
 *
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) { // Kahn's algorithm - 54%% runtime, 88%% memory
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for (int[] edge : prerequisites) {
            inDegree[edge[1]]++;
            adjacencyMap.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
        }

        ArrayDeque<Integer> nodesWithZeroInDegree = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                nodesWithZeroInDegree.add(i);
            }
        }

        int countOfNodesWithZeroInDegree = 0;
        while (!nodesWithZeroInDegree.isEmpty()) {
            int currNode = nodesWithZeroInDegree.remove();
            countOfNodesWithZeroInDegree++;
            if (adjacencyMap.containsKey(currNode)) {
                for (int key : adjacencyMap.get(currNode)) {
                    inDegree[key]--;
                    if (inDegree[key] == 0) {
                        nodesWithZeroInDegree.add(key);
                    }
                }
                // adjacencyMap.remove(currNode); - Slower to remove a key? Since there are no collisions, lookup is still O(1)
            }
        }
        return countOfNodesWithZeroInDegree == numCourses;
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
