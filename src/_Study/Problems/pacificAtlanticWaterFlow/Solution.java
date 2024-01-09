package _Study.Problems.pacificAtlanticWaterFlow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * // TODO - BFS
 * // TODO - Clean up Sloppy BFS
 *
 */
class Solution {
    int m;
    int n;
    int[][] heights;
    int[][] DIRS = {{1,0},{-1,0},{0,-1},{0,1}};
    boolean[][] atlanticCache;
    boolean[][] pacificCache;
    List<List<Integer>> ans;
    public List<List<Integer>> pacificAtlantic(int[][] heights) { // BFS - 33% runtime, 8% memory. Sloppy
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        ans = new ArrayList<>();
        atlanticCache = new boolean[m][n];
        pacificCache = new boolean[m][n];
        boolean[][] seen = new boolean[m][n];


        Queue<int[]> pacificNodesToSearch = new ArrayDeque<>();
        for (int j = 0; j < n; j++) {
            pacificCache[0][j] = true;
            pacificNodesToSearch.add(new int[]{0,j});
        }

        for (int i = 0; i < m; i++) {
            pacificCache[i][0] = true;
            pacificNodesToSearch.add(new int[]{i,0});
        }
        
        while (!pacificNodesToSearch.isEmpty()) {
            int size = pacificNodesToSearch.size();
            for (int i = 0; i < size; i++) {
                int[] currNode = pacificNodesToSearch.remove();

                if (!seen[currNode[0]][currNode[1]]) {
                    seen[currNode[0]][currNode[1]] = true;

                    for (int[] dir : DIRS) {
                        int[] updatedCoord = {currNode[0] + dir[0], currNode[1] + dir[1]};
                        if (isValidCoordinate(updatedCoord[0], updatedCoord[1])) {
                            if (heights[currNode[0]][currNode[1]] <= heights[updatedCoord[0]][updatedCoord[1]]) {
                                pacificNodesToSearch.add(updatedCoord);
                                pacificCache[updatedCoord[0]][updatedCoord[1]] = true;
                            }
                        }
                    }
                }
            }
        }

        seen = new boolean[m][n];
        Queue<int[]> atlanticNodesToSearch = new ArrayDeque<>();
        for (int j = 0; j < n; j++) {
            atlanticCache[m - 1][j] = true;
            atlanticNodesToSearch.add(new int[]{m - 1,j});
        }
        for (int i = 0; i < m; i++) {
            atlanticCache[i][n - 1] = true;
            atlanticNodesToSearch.add(new int[]{i,n - 1});
        }

        while (!atlanticNodesToSearch.isEmpty()) {
            int size = atlanticNodesToSearch.size();
            for (int i = 0; i < size; i++) {
                int[] currNode = atlanticNodesToSearch.remove();

                if (!seen[currNode[0]][currNode[1]]) {
                    seen[currNode[0]][currNode[1]] = true;

                    for (int[] dir : DIRS) {
                        int[] updatedCoord = {currNode[0] + dir[0], currNode[1] + dir[1]};
                        if (isValidCoordinate(updatedCoord[0], updatedCoord[1])) {
                            if (heights[currNode[0]][currNode[1]] <= heights[updatedCoord[0]][updatedCoord[1]]) {
                                atlanticNodesToSearch.add(updatedCoord);
                                atlanticCache[updatedCoord[0]][updatedCoord[1]] = true;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlanticCache[i][j]) {
                    if (pacificCache[i][j]) {
                        ans.add(List.of(i,j));
                    }
                }
            }
        }
        return ans;
    }

    private boolean isValidCoordinate(int i, int j) {
        return i < m && i >= 0 && j >= 0 && j < n;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.pacificAtlantic(
                new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}
        );
        sol.pacificAtlantic(
                new int[][]{{1}}
        );
    }
}