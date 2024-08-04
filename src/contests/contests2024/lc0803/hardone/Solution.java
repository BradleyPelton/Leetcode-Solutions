package contests.contests2024.lc0803.hardone;

// First attempt TLE. Tried plugging in mediumone solution
// Second attempt runtime error
// Third attempt TLE


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    int n;
    Map<Integer, List<List<Integer>>> adjacencyList;
    int[] shortestTime;
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        // new roads are always at least (distance >= 2) (since all distance == 1 already exist)

        // There are no two queries such that
        // queries[i][0] < queries[j][0] (IMPLIES?) < queries[i][1] < queries[j][1].

        // for all i,j then
        // if (source1 < source2) then destination1 > destination2

        // No "Crossing" roads












        this.n = n;
        adjacencyList = new HashMap<>(); // adjacency with weighted edges
        for (int i = 0; i < n - 1; i++) {
            adjacencyList.computeIfAbsent(i, a -> new ArrayList<>()).add(List.of(i + 1, 1)); // (id, weight)
        }
        adjacencyList.put(n - 1, new ArrayList<>());

        shortestTime = new int[n];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);
        shortestTime[0] = 0;

        updateShortest(new int[] {0,0});


        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int source = query[0];
            int destination = query[1];

            for (int j = source + 1; j < destination; j++) {
                adjacencyList.remove(j);
            }

            int shortestPathToSource = shortestTime[source];
            int newShortestPathToDestination = shortestPathToSource + 1;
            if (adjacencyList.containsKey(source)) {
                adjacencyList.get(source).add(List.of(destination, 1));
            }
            shortestTime[destination] = Math.min(shortestTime[destination], newShortestPathToDestination);
            updateShortest(new int[]{destination, newShortestPathToDestination});

            ans[i] = shortestTime[n - 1];
        }

//        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private void updateShortest(int[] arr) {
        PriorityQueue<int[]> nodesToSearch = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        nodesToSearch.add(arr);  // node = {location, totalTravelDistance}

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
    }

//    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
//        int[] shortestTime = new int[n];
//        Map<Integer, Integer> nextCityMap = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            shortestTime[i] = i;
//            nextCityMap.put(i, i + 1);
//        }
//        nextCityMap.remove(n - 1);
//
//        int[] ans = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            int[] query = queries[i];
//            int source = query[0];
//            int destination = query[1];
//
//            for (int j = source + 1; j < destination; j++) {
//                adjacencyList.remove(j);
//            }
//
//            int shortestPathToSource = shortestTime[source];
//            int newShortestPathToDestination = shortestPathToSource + 1;
//            adjacencyList.get(source).add(List.of(destination, 1));
//            shortestTime[destination] = Math.min(shortestTime[destination], newShortestPathToDestination);
//            updateShortest(new int[]{destination, newShortestPathToDestination});
//
//            ans[i] = shortestTime[n - 1];
//        }
//    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.shortestDistanceAfterQueries(
                5,
                new int[][]{{2,4},{0,2},{0,4}}
        );
        sol.shortestDistanceAfterQueries(
                4,
                new int[][]{{0,3},{0,2}}
        );
        sol.shortestDistanceAfterQueries(
                5,
                new int[][]{{1,4},{2,4}}
        ); // unknown


//        java.lang.NullPointerException: Cannot invoke "java.util.List.add(Object)" because the return value of "java.util.Map.get(Object)" is null
//        at line 54, Solution.shortestDistanceAfterQueries
//        at line 56, __DriverSolution__.__helper__
//        at line 89, __Driver__.main
//        5
//                [[1,4],[2,4]]

    }
}