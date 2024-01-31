package _Study.Problems.minCostToConnectAllPoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1584. Min Cost to Connect All Points
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 *
 * A good Minimum Spanning Tree (MST) problem
 * NOTE: Not a canonical example. We are deriving edge weights from manhattan distance here instead of provided edge weights
 *
 * // Kruskal vs Prim
 */
class Solution {
    public class UnionFind { // Boilerplate code for optimized Disjoint set data structure
        //********************** PATH COMPRESSION AND RANK OPTIMIZATIONS INCLUDED
        private final int[] root;
        private final int[] rank; // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        public int numberOfConnectedComponents;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            numberOfConnectedComponents = size;
            for (int i = 0; i < size; i++) { // Initialize each node as disconnected with rank/height = 1
                root[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * @return returns the ULTIMATE parent of node, not the direct parent
         */
        public int find(int node) { // find() with path compression optimization
            if (node == root[node]) {
                return node;
            }
            return root[node] = find(root[node]); // Path compression happens here. Change all intermediate node parents
        }


        /**
         * The union function with union by rank
         *
         * @return returns true if the groups are not of the same group already.
         */
        public boolean union(int nodeOne, int nodeTwo) {
            int rootOfNodeOne = find(nodeOne);
            int rootOfNodeTwo = find(nodeTwo);
            if (rootOfNodeOne != rootOfNodeTwo) {
                if (rank[rootOfNodeOne] > rank[rootOfNodeTwo]) {
                    root[rootOfNodeTwo] = rootOfNodeOne;
                } else if (rank[rootOfNodeOne] < rank[rootOfNodeTwo]) {
                    root[rootOfNodeOne] = rootOfNodeTwo;
                } else {
                    root[rootOfNodeTwo] = rootOfNodeOne;
                    rank[rootOfNodeOne] += 1;
                }
                numberOfConnectedComponents--; // if the two nodes have different roots, unioning them together will decrease the number of components
                return true;
            } else {
                return false;  // no union performed, returning false
            }
        }

        public boolean connected(int nodeOne, int nodeTwo) {
            return find(nodeOne) == find(nodeTwo);
        }
        public int getCount() {
            return numberOfConnectedComponents;
        }
        public int getNumberOfConnectedComponents() {
            return getCount();
        }
    }

//    public int minCostConnectPoints(int[][] points) { // Kruskal's algorithm - Minimum Spanning Tree (MST) - 34% runtime, 30% memory
//        int n = points.length;
//        List<int[]> edges = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                edges.add(new int[]{i, j, manhattanDistance(points[i], points[j])});
//            }
//        }
//
//        Collections.sort(edges, Comparator.comparingInt(a -> a[2]));
//
//        UnionFind uf = new UnionFind(n);
//        int totalCost = 0;
//        for(int[] edge : edges) {
//            if (uf.union(edge[0], edge[1])) {
//                totalCost += edge[2];
//                if (uf.numberOfConnectedComponents == 1) {
//                    break;
//                }
//            }
//        }
//        System.out.println(totalCost);
//        return totalCost;
//    }

    public int minCostConnectPoints(int[][] points) { // Prim's algorithm - Minimum Spanning Tree (MST) - 71% runtime, 62 memory
        int n = points.length;

        PriorityQueue<int[]> edgePQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[] connected = new boolean[n];

        // Choose an arbitrary source/root node
        int root = 0;
        connected[root] = true;
        for (int i = 1; i < n; i++) {
            edgePQ.add(new int[]{0, i, manhattanDistance(points[0], points[i])}); // {from, to, weight}
        }

        int totalCost = 0;
        int numberOfEdges = 0;
        while (numberOfEdges != n - 1) {
            int[] nextSmallestEdge = edgePQ.remove();
            if (!connected[nextSmallestEdge[1]]) {
                totalCost += nextSmallestEdge[2];
                numberOfEdges++;
                connected[nextSmallestEdge[1]] = true;
                for (int i = 0; i < n; i++) {
                    if (!connected[i]) {
                        edgePQ.add(new int[]{nextSmallestEdge[1], i, manhattanDistance(points[nextSmallestEdge[1]], points[i])});
                    }
                }
            }
        }
        System.out.println(totalCost);
        return totalCost;
    }

    private int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minCostConnectPoints(
                new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}
        ); // 20
        sol.minCostConnectPoints(
                new int[][]{{3,12},{-2,5},{-4,1}}
        ); // 18
    }
}