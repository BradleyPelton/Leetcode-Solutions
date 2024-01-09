package _Study.Problems.djikstraTODO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        Integer[][] allDistances = new Integer[n][n];

        Map<Integer, Map<Integer, Integer>> adjList = new HashMap<>();
        for (int[] road : roads) {
            int source = road[0];
            int destination = road[1];
            int length = road[2];
            allDistances[source][destination] = length;
            allDistances[destination][source] = length;

            adjList.putIfAbsent(source, new HashMap<>());
            adjList.get(source).put(destination, length);

            // TODO - Trim parallel edges

            adjList.putIfAbsent(destination, new HashMap<>());
            adjList.get(destination).put(source, length);
        }

        for (int i = 0; i < n; i++) {

            Set<Integer> settledNodes = new HashSet<>();
            Set<Integer> unsettledNodes = new HashSet<>();
            unsettledNodes.add(i);

            while (unsettledNodes.size() != 0) {
//                int currentNode = getLowestDistanceNode(unsettledNodes);
//                unsettledNodes.remove(currentNode);
//                for (Map.Entry<Integer, Integer> adjacencyPair: adjList.get(currentNode).entrySet()) {
//                    int adjacentNode = adjacencyPair.getKey();
//                    Integer edgeWeight = adjacencyPair.getValue();
//                    if (!settledNodes.contains(adjacentNode)) {
//                        if (adjList.get(adjacentNode).containsKey(currentNode)) {
//                            distance =
//                        }
//                        calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
//                        unsettledNodes.add(adjacentNode);
//                    }
//                }
//                settledNodes.add(currentNode);
            }

        }
        return -42;
    }
}
