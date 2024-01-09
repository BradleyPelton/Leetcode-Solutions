package _Study.Problems.numberOfConnectedComponentsInAnUndirectedGraph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 *
 * // TODO  - UnionFind is a natural solution here.
 * // TODO - BFS
 */
class Solution {
    Map<Integer, List<Integer>> adjacencyList;
    boolean[] seen;
    int numberOfConnectedComponents;
    public int countComponents(int n, int[][] edges) { // DFS - 6% runtime, 5% memory
        numberOfConnectedComponents = 0;
        seen = new boolean[n];
        adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
            adjacencyList.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                numberOfConnectedComponents++;
                dfs(i);
            }
        }
        System.out.println(numberOfConnectedComponents);
        return numberOfConnectedComponents;
    }

    private void dfs(int node) {
        if (!seen[node]) {
            seen[node] = true;
            if (adjacencyList.containsKey(node)) {
                for (int downstreamNode : adjacencyList.get(node)) {
                    dfs(downstreamNode);
                }
            }
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countComponents(
                5,
                new int[][]{{0,1},{1,2},{3,4}}
        );
        sol.countComponents(
                5,
                new int[][]{{0,1},{1,2},{2,3},{3,4}}
        );
    }
}