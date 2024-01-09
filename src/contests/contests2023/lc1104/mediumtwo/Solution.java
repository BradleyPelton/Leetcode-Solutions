package contests.contests2023.lc1104.mediumtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, List<Integer>> adjacencyMap;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        adjacencyMap = new HashMap<>();  // Debatable to use a adjacency list instead.
        for (int[] edge : edges) {
            if (adjacencyMap.containsKey(edge[0])) {
                adjacencyMap.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(edge[1]);
                adjacencyMap.put(edge[0], temp);
            }
            if (adjacencyMap.containsKey(edge[1])) {
                adjacencyMap.get(edge[1]).add(edge[0]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(edge[0]);
                adjacencyMap.put(edge[1], temp);
            }
        }

        long totalSum = Arrays.stream(values).mapToLong(i -> i).sum(); // IntStream returns int, have to use LongStream
        long minToRemove = minimumToRemove(values, 0, -1);
        long ans = totalSum - minToRemove;
        System.out.println("ans = " + ans);
        return ans;
    }

    private long minimumToRemove(int[] values, int nodeNumber, int parentNodeNumber) {
        long absoluteMin;
        long minFromChildren = 0L;
        if (adjacencyMap.containsKey(nodeNumber)) {
            int numberOfChildrenChecked = 0;
            for (int childNodeNumber : adjacencyMap.get(nodeNumber)) {
                if (childNodeNumber != parentNodeNumber) {
                    numberOfChildrenChecked++;
                    minFromChildren += minimumToRemove(values, childNodeNumber, nodeNumber);
                }
            }

            if (numberOfChildrenChecked > 0) {
                absoluteMin = Math.min(
                        values[nodeNumber], // remove the node itself, thus satisfying condition
                        minFromChildren
                );
            } else {
                absoluteMin = values[nodeNumber];
            }
        } else {
            absoluteMin = values[nodeNumber];
        }
        return absoluteMin;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol =  new Solution();
        sol.maximumScoreAfterOperations(
                new int[][]{{0,1},{0,2},{0,3},{2,4},{4,5}},
                new int[]{5,2,5,2,1,1}
        ); // expected 11
        sol.maximumScoreAfterOperations(
                new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}},
                new int[]{20,10,9,7,4,3,5}
        ); // expected 40
        sol.maximumScoreAfterOperations(
                new int[][]{{2,0},{4,1},{5,3},{4,6},{2,4},{5,2},{5,7}},
                new int[]{12,12,7,9,2,11,12,25}
        ); // expected 83
        sol.maximumScoreAfterOperations(
                new int[][]{{5,1},{4,3},{2,4},{6,2},{0,5},{0,6}},
                new int[]{18,24,5,20,23,6,7}
        ); // expected 92
    }
}