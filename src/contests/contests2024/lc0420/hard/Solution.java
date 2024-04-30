package contests.contests2024.lc0420.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        List<List<String>> shortestPathStrings = new ArrayList<>(); // shortestPath from 0 -> i
        for (int i = 0; i < n; i++) {
            shortestPathStrings.add(new ArrayList<>());
        }
        shortestPathStrings.get(0).add("0");

        Map<Integer, List<List<Integer>>> adjacencyList = new HashMap<>(); // adjacency with weighted edges
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(List.of(edge[1],edge[2])); // (id, weight)
        }

        Map<String, Integer> edgeIndex = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            edgeIndex.put(edges[i][0] + "->" + edges[i][1], i);
        }

        int[] shortestTime = new int[n + 1];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);

        PriorityQueue<String[]> nodesToSearch = new PriorityQueue<>(Comparator.comparingInt(a -> Integer.parseInt(a[1])));
        nodesToSearch.add(new String[]{"0", "0", "0"});  // node = {location, totalWeight, currPathString}
        shortestTime[0] = 0;

        while (!nodesToSearch.isEmpty()) {
            String[] node = nodesToSearch.remove();
            int currNode = Integer.parseInt(node[0]);
            int currWeight = Integer.parseInt(node[1]);
            String currPath = node[2];

            if (adjacencyList.containsKey(currNode)) {
                for (List<Integer> neighbor : adjacencyList.get(currNode)) {
                    int newWeight = neighbor.get(1) + currWeight;

                    if (shortestTime[neighbor.get(0)] == newWeight) {
                        String newPath = currPath + "," + neighbor.get(0);
                        shortestPathStrings.get(neighbor.get(0)).add(newPath);
                    }

                    else if (shortestTime[neighbor.get(0)] > neighbor.get(1) + currWeight) {
                        shortestPathStrings.get(neighbor.get(0)).clear();

                        shortestTime[neighbor.get(0)] = newWeight; // IMPORTANT: update shortest before enqueueing


                        String newPath = currPath + "," + neighbor.get(0);
                        shortestPathStrings.get(neighbor.get(0)).add(newPath);
                        nodesToSearch.add(new String[]{
                                neighbor.get(0) + "",
                                newWeight + "",
                                newPath
                        });
                    }
                }
            }
        }



        boolean[] ans = new boolean[edges.length];

        for (String path : shortestPathStrings.get(n - 1)) {
            String[] nodes = path.split(",");

            String previousNode = nodes[0];
            for(int i = 1; i < nodes.length; i++) {
                String pathString = previousNode + "->" + nodes[i];
                int indexOfPath = edgeIndex.get(pathString);
                ans[indexOfPath] = true;

                previousNode = nodes[i];
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findAnswer(
                6,
                new int[][]{{0,1,4},{0,2,1},{1,3,2},{1,4,3},{1,5,1},{2,3,1},{3,5,3},{4,5,2}}
        );
        sol.findAnswer(
                4,
                new int[][]{{2,0,1},{0,1,1},{0,3,4},{3,2,2}}
        );



    }
}