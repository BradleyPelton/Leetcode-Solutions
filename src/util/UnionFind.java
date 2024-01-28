package util;

/**
 * Union Find (aka Disjoint set) is a data structure
 * used to efficiently determine graph connectivity (e.g. number of connected components)
 * <p>
 * There are many implementations of UnionFind. Some are optimized for search while some are optimized for insert.
 * Some variants store the direct parent of a node, while other variants store the ultimate parent.
 * <p>
 * Two Primary Methods:
 *      1. Find - return the root(parent???) node ((e.g. the group that the individual a belongs to. ))
 *      2. Union - union together two components. Change the parent node of one of the two inputs.
 * </p>
 *
 */
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


// UnionFind with path compression but not rank optimization
//class UnionFind {
//    private int[] root;
//
//    public UnionFind(int size) {
//        root = new int[size];
//        for (int i = 0; i < size; i++) {
//            root[i] = i;
//        }
//    }
//
//    public int find(int x) {
//        if (x == root[x]) {
//            return x;
//        }
//        return root[x] = find(root[x]);
//    }
//
//    public void union(int x, int y) {
//        int rootX = find(x);
//        int rootY = find(y);
//        if (rootX != rootY) {
//            root[rootY] = rootX;
//        }
//    }
//
//    public boolean connected(int x, int y) {
//        return find(x) == find(y);
//    }
//}