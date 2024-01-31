package _Study.Problems.networkDelayTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 743. Network Delay Time
 * https://leetcode.com/problems/network-delay-time
 * <p>
 * Shortest path between for all vertices. Max of shortest paths.
 * </p>
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) { // Dijkstra - 47% runtime, 25% memory
        int source = k; // renaming variable;
        Map<Integer, List<List<Integer>>> adjacencyList = new HashMap<>(); // adjacency with weighted edges
        for (int[] time : times) {
            adjacencyList.computeIfAbsent(time[0], a -> new ArrayList<>()).add(List.of(time[1],time[2])); // (id, weight)
        }

        int[] shortestTime = new int[n + 1]; // [1..n] 1-indexed because dumb.
        Arrays.fill(shortestTime, Integer.MAX_VALUE);

        PriorityQueue<int[]> nodesToSearch = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        nodesToSearch.add(new int[]{source, 0});  // node = {location, totalTravelDistance}
        shortestTime[source] = 0;

        while (!nodesToSearch.isEmpty()) {
            int[] node = nodesToSearch.remove();
            if (adjacencyList.containsKey(node[0])) {
                for (List<Integer> neighbor : adjacencyList.get(node[0])) {
                    if (shortestTime[neighbor.get(0)] > neighbor.get(1) + node[1]) {
                        shortestTime[neighbor.get(0)] = neighbor.get(1) + node[1]; // IMPORTANT: update shortest before enqueueing
                        nodesToSearch.add(new int[]{neighbor.get(0), node[1] + neighbor.get(1)});
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) { // [1..n] 1-indexed because dumb.
            ans = Math.max(ans, shortestTime[i]);
        }
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.networkDelayTime(
                new int[][]{{2,1,1},{2,3,1},{3,4,1}},
                4,
                2
        );
        sol.networkDelayTime(
                new int[][]{{1,2,1}},
                2,
                1
        );
        sol.networkDelayTime(
                new int[][]{{1,2,1}},
                2,
                2
        );
    }
}
