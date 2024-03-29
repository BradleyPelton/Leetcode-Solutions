package _Study.Problems.graphValidTree;

import util.UnionFind;

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
 * Return true if a graph is a valid tree
 *
 *
 * Tree defn: connected acyclic graph
 * Tree IFF Maximally connected IFF Acyclic Connected
 * Tree IFF (n - 1) edges and fully connected
 *
 * // TODO - BFS and DFS
 */
class Solution {
    Set<Integer> visited;
    Map<Integer, List<Integer>> adjacencyList;

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

    public boolean validTree(int n, int[][] edges) { // UnionFind - 83% runtime, 60% memory
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                System.out.println("false, cycle detected"); // if the parent is already equal, there is already a path
                return false;
            }
        }

        if (uf.numberOfConnectedComponents > 1) {
            System.out.println("false, graph is not connected");
            return false;
        }
        System.out.println("true");
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
        sol.validTree(
                3,
                new int[][]{{1,0},{2,0}}
        );
        sol.validTree(
                4,
                new int[][]{{2,3},{1,2},{1,3}}
        );
    }
}
