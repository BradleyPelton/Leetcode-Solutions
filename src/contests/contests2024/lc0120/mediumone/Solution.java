package contests.contests2024.lc0120.mediumone;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


// Holy shit
// Djikstra multiple sources
// SOlved after first attempt
// Sovled after 20 minutes


// Lessons: BFS for shortest path for unweighted runs in linear time
// Since Djikstra uses a PQ, it runs in O (n log n)


class Solution {
    int n;
    int x;
    int y;
    int[] ans;
    public int[] countOfPairs(int n, int x, int y) {
        this.n = n;
        this.x = x;
        this.y = y;
        ans = new int[n];

        for (int i = 1; i <= n; i++) {
            bfs(i); // BFS to calculate distance to each house. Update answer while calculating distance
        }
        return ans;
    }

    private void bfs(int source) {
        int[] shortestTime = new int[n + 1];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);
        shortestTime[source] = 0;

        Queue<Integer> nodesToSearch = new ArrayDeque<>();
        nodesToSearch.add(source);
        int currDistance = 0;

        while (!nodesToSearch.isEmpty()) {
            currDistance++;
            int size = nodesToSearch.size();
            for (int i = 0; i < size; i++) {
                int node = nodesToSearch.remove();

                // forward
                if (node < n && shortestTime[node + 1] > currDistance) {
                    shortestTime[node + 1] = currDistance;
                    nodesToSearch.add(node + 1);
                }
                // back
                if (node > 1 && shortestTime[node - 1] > currDistance) {
                    shortestTime[node - 1] = currDistance;
                    nodesToSearch.add(node - 1);
                }
                // x
                if (node == x) {
                    if (shortestTime[y] > currDistance) {
                        shortestTime[y] = currDistance;
                        nodesToSearch.add(y);
                    }
                }
                // y
                if (node == y) {
                    if (shortestTime[x] > currDistance) {
                        shortestTime[x] = currDistance;
                        nodesToSearch.add(x);
                    }
                }
            }
        }

        for(int val : shortestTime) {
            if (val > 0 && val != Integer.MAX_VALUE) {
                ans[val - 1]++; // off by 1 because leetcode likes to torture us
            }
        }
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countOfPairs(3,1,3);
        sol.countOfPairs(5,2,4);
        sol.countOfPairs(4,1,1);
    }
}
