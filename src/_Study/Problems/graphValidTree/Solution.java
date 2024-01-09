package _Study.Problems.graphValidTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/**
 * 261. Graph Valid Tree
 * https://leetcode.com/problems/graph-valid-tree/description/
 *
 *
 */
class Solution {
    Set<Integer> visited;
    Map<Integer, List<Integer>> adjacencyList;
    public boolean validTree(int n, int[][] edges) {
        visited = new HashSet<>(n);
        adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
            adjacencyList.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(edge[0]);
        }
        boolean isTree = bfs(0, -1);
        if (!isTree) {
            System.out.println("false, bad tree");
            return false;
        } else if (visited.size() != n) {
            System.out.println("false, missing visits");
            return false;
        }
        System.out.println("true");
        return true;
    }

    private boolean bfs(int node, int parentNode) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        Queue<Integer> nodesToSearch = new ArrayDeque<>();
        nodesToSearch.add(node);

        List<Integer> out = adjacencyList.getOrDefault(node, List.of()); // orDefault for leaf nodes
        for (int outNode : out) {
            if (outNode != parentNode) {
                boolean outBool = bfs(outNode, node);
                if (!outBool) {
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
        sol.validTree(
                5,
                new int[][]{{0,1},{0,2},{0,3},{1,4}}
        );
        sol.validTree(
                5,
                new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}}
        );
    }
}
