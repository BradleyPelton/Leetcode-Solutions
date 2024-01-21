package _Study.Problems.djikstraTODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

    // Example problem used https://leetcode.com/problems/network-delay-time/description/
    // Find the "heaviest" path/max pathSum from source to any node

    public int networkDelayTime(int[][] times, int n, int source) {
        int[] shortestTime = new int[n];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);

        Map<Integer, List<List<Integer>>> adjacencyList = new HashMap<>(); // adjacency with weighted edges
        for (int[] time : times) {
            adjacencyList.computeIfAbsent(time[0], a -> new ArrayList<>()).add(List.of(time[1],time[2])); // (id, weight)
        }

        // node = {location, totalTravelDistance}
        PriorityQueue<int[]> nodesToSearch = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        nodesToSearch.add(new int[]{source, 0});

        while (!nodesToSearch.isEmpty()) {
            int[] node = nodesToSearch.remove();
            if (shortestTime[node[0]] > node[1]) {
                shortestTime[node[0]] = node[1];

                if (adjacencyList.containsKey(node[0])) {
                    for (List<Integer> edge : adjacencyList.get(node[0])) {
                        nodesToSearch.add(new int[]{edge.get(0), node[1] + edge.get(1)});
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int time : shortestTime) {
            ans = Math.max(ans, time);
        }
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
        return ans;
    }
}
