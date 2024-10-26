package contests.contests2024.lc1005.mediumone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted after 31 minutes
// Accepted first try

// I thought this was a UnionFind problem.
// Wasted 10 minutes. Took 10 minutes to understand the weird wording of the question

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

    int n;
    Map<Integer, List<Integer>> adjacencyList;
    boolean[] isSus = new boolean[n];
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        this.n = n;
        isSus = new boolean[n];
        adjacencyList = new HashMap<>();
        for (int[] edge : invocations) {
            adjacencyList.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
        }

        markSus(k);

        // If any sus node is connected to nonSus node, return nothing.

        boolean nothingCanBeRemoved = false;
        for (int[] edge : invocations) {
            if (!isSus[edge[0]] && isSus[edge[1]]) {
                nothingCanBeRemoved = true;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (nothingCanBeRemoved) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            System.out.println("nothingCanBeRemoved "  + ans);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (!isSus[i]) {
                ans.add(i);
            }
        }
//        System.out.println(ans);
        return ans;




//        UnionFind uf = new UnionFind(n);
//        for (int[] edge : invocations) {
//            uf.union(edge[0], edge[1]);
////            uf.union(edge[1], edge[0]);
//        }
//
//        int badRoot = uf.root[k];
//        List<Integer> affected = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (uf.root[i] == badRoot) {
//                affected.add(i);
//            }
//        }
//
//        if (unaffected.isEmpty()) {
//            System.out.println("{} all sus");
//            return unaffected;
//        }
//
//        System.out.println(unaffected);
//        return unaffected;
    }


    private void markSus(int node) {
        isSus[node] = true;
        for (Integer neighbor : adjacencyList.getOrDefault(node, List.of())) {
            if (!isSus[neighbor]) {
                isSus[neighbor] = true;
                markSus(neighbor);
            }
        }
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.remainingMethods(
                4,
                1,
                new int[][]{{1,2},{0,1},{3,2}}
        );
        sol.remainingMethods(
                5,
                0,
                new int[][]{{1,2},{0,2},{0,1},{3,4}}
        );
        sol.remainingMethods(
                3,
                2,
                new int[][]{{1,2},{0,1},{2,0}}
        );




    }
}
