package contests.contests2024.lc0831.mediumone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Accepted first attempt
// Accepted after 8 minutes
// Variant of "215. Kth Largest Element in an Array"

class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] ans = new int[n];

        PriorityQueue<int[]> closestPoints = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));


        for (int i = 0; i < n; i++) {
            int[] temp = new int[] {queries[i][0], queries[i][1], getDistance(queries[i])};
            closestPoints.add(temp);

            if (closestPoints.size() < k) {
                ans[i] = -1;
            } else if (closestPoints.size() > k) {
                closestPoints.remove();
                int[] top = closestPoints.peek();
                int distance = getDistance(top);
                ans[i] = distance;
            } else {
                int[] top = closestPoints.peek();
                int distance = getDistance(top);
                ans[i] = distance;
            }

        }

//        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private int getDistance(int[] coord) {
        return Math.abs(coord[0]) + Math.abs(coord[1]);
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.resultsArray(
                new int[][]{{1,2},{3,4},{2,3},{-3,0}},
                2
        );
        sol.resultsArray(
                new int[][]{{5,5},{4,4},{3,3}},
                1
        );




    }
}
