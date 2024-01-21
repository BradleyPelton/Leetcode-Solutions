package contests.contests2024.lc0120.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Time limit Exceeded
// Was fun optimizing. BFS is pretty, but the trick the BCR is definitely not O(n**2)

class Solution {
    int n;
    int x;
    int y;
    long[] ans;
    public long[] countOfPairs(int n, int x, int y) {
        this.n = n;
        this.x = x;
        this.y = y;
        ans = new long[n];

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private void bfs(int source) {
        int[] shortestTime = new int[n + 1];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);

        Queue<Integer> nodesToSearch = new ArrayDeque<>();
        nodesToSearch.add(source);
        int currDistance = -1;

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
            if (val > 0 && val <= n) {
                ans[val - 1]++;
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
        sol.countOfPairs(1000,664, 997);

    }
}