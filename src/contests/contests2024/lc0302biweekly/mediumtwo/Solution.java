package contests.contests2024.lc0302biweekly.mediumtwo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted second attempt
// Accepted after 1 hour. Longggggg problem
// First attempt was wrong because I assumed the tree was a binary tree. Refactoring for generic n-ary tree took 15 mins
// Confusing problem.

class Solution {
    Map<Integer, List<List<Integer>>> adjacencyList;
    int n;
    int signalSpeed;
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        n = edges.length + 1; // tree iff edges.length() == n - 1
        this.signalSpeed = signalSpeed;

        adjacencyList = new HashMap<>(); // adjacency with weighted edges
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(List.of(edge[1],edge[2])); // (id, weight)
            adjacencyList.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(List.of(edge[0],edge[2])); // (id, weight)
        }
        // The input is generated such that edges represents a valid tree
        // Thus no cycles

        int n = edges.length + 1; // tree iff edges.length() == n - 1

        boolean[][] isConnected = new boolean[n][n];


        // The path from a -> c and the path from b -> c do not share any edges
        // therefore c has to be a

        // Treat "C" as the root node, A in left, b ins in right
        int[] ans = new int[n];
        for (int root = 0; root < n; root++) {

            List<List<Integer>> goodNodes = getGoodNodes(root);
            int localAns = 1;
            int numberOfGoodSubTrees = 0;
            for (List<Integer> goodSubTree : goodNodes) {
                if (!goodSubTree.isEmpty()) {
                    numberOfGoodSubTrees++;
                    localAns *= goodSubTree.size();
                }
            }
            if (numberOfGoodSubTrees != 0) {
                ans[root] = localAns;
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private List<List<Integer>> getGoodNodes(int root) {
        List<List<Integer>> goodNodes = new ArrayList<>();
        if (!adjacencyList.containsKey(root)) {
            return goodNodes;
        }

        // LEFT
        Deque<int[]> nodesToSearch = new ArrayDeque<>(); // {node, distance, parent, equivalenceClass}
        int equivalenceClassIndex = 0;
        for (List<Integer> edge : adjacencyList.get(root)) {
            goodNodes.add(new ArrayList<>());

            int[] equivalenceNode = {edge.get(0), edge.get(1), root, equivalenceClassIndex};
            if (equivalenceNode[1] % signalSpeed == 0) {
                goodNodes.get(equivalenceClassIndex).add(equivalenceNode[0]);
            }
            nodesToSearch.add(equivalenceNode);
            equivalenceClassIndex++;
        }

        while (!nodesToSearch.isEmpty()) {
            int[] currNode = nodesToSearch.remove();
            if (adjacencyList.containsKey(currNode[0])) {
                for (List<Integer> edge : adjacencyList.get(currNode[0])) {
                    if (edge.get(0) != currNode[2]) {
                        int[] nextNode = {edge.get(0), currNode[1] + edge.get(1), currNode[0], currNode[3]};
                        if (nextNode[1] % signalSpeed == 0) {
                            goodNodes.get(nextNode[3]).add(nextNode[0]);
                        }
                        nodesToSearch.add(nextNode);
                    }
                }
            }
        }
        return goodNodes;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countPairsOfConnectableServers(
                new int[][]{{0,1,1},{1,2,5},{2,3,13},{3,4,9},{4,5,2}},
                1
        ); // [0,4,6,6,4,0]
        sol.countPairsOfConnectableServers(
                new int[][]{{0,6,3},{6,5,3},{0,3,1},{3,2,7},{3,1,6},{3,4,2}},
                3
        ); // [2,0,0,0,0,0,2]
        sol.countPairsOfConnectableServers(
                new int[][]{{1,0,2},{2,1,4},{3,2,4},{4,0,3},{5,1,4},{6,2,2},{7,6,4},{8,1,2},{9,8,3}},
                1
        ); //[8,28,20,0,0,0,8,0,8,0]


    }
}
