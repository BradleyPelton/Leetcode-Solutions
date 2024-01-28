package _Study.Problems.numberOfProvinces;


/**
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/
 *
 * Canonical UnionFind (Disjoint-Union) problem.
 * Count the number of connected components in the graph
 *
 * // TODO - DFS and BFS
 *
 */
class Solution {
    public class UnionFind { // Boilerplate code for optimized Disjoint set data structure
        //********************** PATH COMPRESSION AND RANK OPTIMIZATIONS INCLUDED
        private final int[] root;
        private final int[] rank; // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        int numberOfConnectedComponents;

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
    public int findCircleNum(int[][] isConnected) { // UnionFind (dsjoint-union) - 28% runtime, 27% memory
        n = isConnected.length;
        UnionFind uj = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uj.union(i, j);
                }
            }
        }

        int ans = uj.numberOfConnectedComponents;
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findCircleNum(
                new int[][]{{1,1,0},{1,1,0},{0,0,1}}
        ); // 2
        sol.findCircleNum(
                new int[][]{{1,0,0},{0,1,0},{0,0,1}}
        ); // 3
        sol.findCircleNum(
                new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}
        ); // 1
    }
}
