package _Study.Problems.allPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 *
 *
 * Classical Backtracking problem
 * No loops makes simplifies this problem a lot.
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        localPath(graph, new ArrayList<>(List.of(0)));
        System.out.println(ans);
        return ans;
    }

    private void localPath(int[][] graph, List<Integer> currPath) {
        int currentNode = currPath.get(currPath.size() - 1);
        if (currentNode == graph.length - 1) {
            ans.add(new ArrayList<>(currPath));
            return;
        }

        int[] nextSteps = graph[currentNode];
        for (int nextNode : nextSteps) {
            currPath.add(nextNode);
            localPath(graph, currPath);
            currPath.remove(currPath.size() - 1);
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
        sol.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});
    }
}
